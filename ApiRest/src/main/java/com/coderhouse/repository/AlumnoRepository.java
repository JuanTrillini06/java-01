package com.coderhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
