package com.exercise.language.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.language.entity.ProgramingLanguage;

public interface ProgramingLanguageRepository extends JpaRepository<ProgramingLanguage, UUID> {



}
