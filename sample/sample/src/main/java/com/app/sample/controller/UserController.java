package com.app.sample.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.sample.dto.ErrorDto;
import com.app.sample.dto.LoginRequest;
import com.app.sample.dto.UserDto;
import com.app.sample.entity.User;
import com.app.sample.enumeration.RequestType;
import com.app.sample.repository.UserRepository;
import com.app.sample.response.ResponseGenerator;
import com.app.sample.response.TransactionContext;
import com.app.sample.security.JwtTokenUtil;
import com.app.sample.service.MessagePropertyService;
import com.app.sample.service.UserService;
import com.app.sample.util.PasswordUtil;
import com.app.sample.validation.UserValidator;
import com.app.sample.validation.ValidationResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/api/user")
@Api(value = "User Rest API's", produces = "application/json", consumes = "application/json")
public class UserController {
	
private static final Logger logger = Logger.getLogger(UserController.class);
	
	private @NonNull ResponseGenerator responseGenerator; 
	
	private @NonNull MessagePropertyService messagePropertySource;
	
	private @NonNull UserValidator userValidator;
	
	private @NonNull  MessageSource messageSource;
	
	private @NonNull UserService userService;
	
	private @NonNull UserRepository userRepository;
	
	private @NonNull JwtTokenUtil jwtTokenUtil;

	
	
	@ApiOperation(value = "Allows to create new user.", response = Response.class)
	@PostMapping(value = "/create", produces = "application/json")
	public ResponseEntity<?> create(@ApiParam(value = "The user request payload") @RequestBody UserDto request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {
		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {			
			ValidationResult validationResult = userValidator.validate(RequestType.POST, request);
			userService.saveOrUpdate((User) validationResult.getObject());

			return responseGenerator.successResponse(context, "user.create", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);
	}
		
	}
	@ApiOperation(value = "Logs the user in to the system and return the auth tokens")
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> login(@ApiParam(value = "The LoginRequest payload") @RequestBody LoginRequest request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {
		ErrorDto errorDto = null;
		Map<String, Object> response = new HashMap<String, Object>();
		if (null == request) {
			errorDto = new ErrorDto();
			errorDto.setCode("400");
			errorDto.setMessage("Invalid request payload.!");
			response.put("status", 0);
			response.put("error", errorDto);
			return ResponseEntity.badRequest().body(response);
		}

		Optional<User> userOptional = userRepository.findByUserName(request.getUserName());
		if (!userOptional.isPresent()) {
			errorDto = new ErrorDto();
			errorDto.setCode("400");
			errorDto.setMessage("Invalid username.!");
			response.put("status", 0);
			response.put("error", errorDto);
			return ResponseEntity.badRequest().body(response);
		}
		User user = userOptional.get();
		String enPassword = PasswordUtil.getEncryptedPassword(request.getPassword());

		if (!user.getUserName().equals(request.getUserName())) {
			errorDto = new ErrorDto();
			errorDto.setCode("400");
			errorDto.setMessage("Invalid username.!");
			response.put("status", 0);
			response.put("error", errorDto);
			return ResponseEntity.badRequest().body(response);
		}
		if (!user.getPassword().equals(enPassword)) {
			errorDto = new ErrorDto();
			errorDto.setCode("400");
			errorDto.setMessage("Password is wrong.!");
			response.put("status", 0);
			response.put("error", errorDto);
			return ResponseEntity.badRequest().body(response);
		}

		final String token = jwtTokenUtil.generateToken(user);
		response.put("status", 1);
		response.put("message", "Logged in successfully.!");
		response.put("jwt", token);
		// response.put("isOtpVerified", user.getIsOtpVerified());
		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
		try {
			return responseGenerator.successResponse(context, response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		/*
		 * logger.info(response.toString()); return
		 * ResponseEntity.accepted().body(response);
		 */
	}

}