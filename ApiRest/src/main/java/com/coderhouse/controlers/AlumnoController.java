package com.coderhouse.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Alumno;
import com.coderhouse.repository.AlumnoRepository;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@GetMapping
	public List<Alumno> getAllAlumnos(){
		return alumnoRepository.findAll();
	}
	
	
	@GetMapping("/{alumnoId}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long alumnoId){
		try {
			if(alumnoRepository.existsById(alumnoId)) {
				Alumno alumno = alumnoRepository.findById(alumnoId).get();
				return ResponseEntity.ok(alumno); //200
			}else {
				return ResponseEntity.notFound().build(); //404
			}
		}catch(Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		}
	}
	
	
	@PostMapping("/create")
	public Alumno createAlumno(@RequestBody Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
}
