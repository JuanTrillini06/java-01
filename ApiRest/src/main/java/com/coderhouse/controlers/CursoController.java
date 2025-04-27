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

import com.coderhouse.models.Curso;
import com.coderhouse.services.CursoServicio;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	
	@Autowired
	private CursoServicio cursoServicio;

	@GetMapping
	public List<Curso> getAllCursos(){
		return cursoServicio.findAll();
	}
	
	
	@GetMapping("/{cursoId}")
	public ResponseEntity<Curso> getCursoById(@PathVariable Long cursoId){
		try {
			Curso curso = cursoServicio.findById(cursoId);
			return ResponseEntity.ok(curso); //200
		}catch(IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); //404
		}catch(Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		}
	}
	
	
	@PostMapping("/create")
	public Curso createCurso(@RequestBody Curso curso) {
		return cursoServicio.save(curso);
	}
	
	@PutMapping("/{cursoId}")
	public ResponseEntity<Curso> updateCursoById(@PathVariable Long cursoId, @RequestBody Curso cursoActualizado){
		try {
			Curso curso = cursoServicio.update(cursoId, cursoActualizado);
			return ResponseEntity.ok(curso); //200
		}catch(IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); //404
		}catch(Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		}
	}
	
	@DeleteMapping("/{cursoId}")
	public ResponseEntity<Void> deleteCursoById(@PathVariable Long cursoId){
		try {
			cursoServicio.deleteById(cursoId);
			return ResponseEntity.noContent().build(); //404
		}catch(IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); //404
		}catch(Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		}
	}
}
