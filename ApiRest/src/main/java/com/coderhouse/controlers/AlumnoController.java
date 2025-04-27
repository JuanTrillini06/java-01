package com.coderhouse.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Alumno;
import com.coderhouse.services.AlumnoServicio;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
	
	@Autowired
	private AlumnoServicio alumnoServicio;

	@GetMapping
	public List<Alumno> getAllAlumnos(){
		return alumnoServicio.findAll();
	}
	
	
	@GetMapping("/{alumnoId}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long alumnoId){
		try {
				Alumno alumno = alumnoServicio.findById(alumnoId);
				return ResponseEntity.ok(alumno); //200
		}catch(IllegalArgumentException err) {
				return ResponseEntity.notFound().build(); //404
		}catch(Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		}
	}	
	
	@PostMapping("/create")
	public Alumno createAlumno(@RequestBody Alumno alumno) {
		return alumnoServicio.save(alumno);
	}
	
	@PutMapping("/{alumnoId}")
	public ResponseEntity<Alumno> updateAlumnoById(@PathVariable Long alumnoId, @RequestBody Alumno alumnoActualizado){
		try {
			Alumno alumno = alumnoServicio.update(alumnoId, alumnoActualizado);
			return ResponseEntity.ok(alumno); //200
		}catch(IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); //404
		}catch(Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		}
	}
	
	@DeleteMapping("/{alumnoId}")
	public ResponseEntity<Void> deleteAlumnoById(@PathVariable Long alumnoId){
		try {
			alumnoServicio.deleteById(alumnoId);
			return ResponseEntity.noContent().build(); //404
		}catch(IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); //404
		}catch(Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		}
	}
}
