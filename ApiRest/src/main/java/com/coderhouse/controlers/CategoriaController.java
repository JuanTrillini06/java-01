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

import com.coderhouse.models.Categoria;
import com.coderhouse.repository.CategoriaRepository;



@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> getAllCategoria(){
		return categoriaRepository.findAll();
	}
	
	
	@GetMapping("/{categoriaId}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long categoriaId){
		try {
			if(categoriaRepository.existsById(categoriaId)) {
				Categoria categoria = categoriaRepository.findById(categoriaId).get();
				return ResponseEntity.ok(categoria); //200
			}else {
				return ResponseEntity.notFound().build(); //404
			}
		}catch(Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		}
	}
	
	
	@PostMapping("/create")
	public Categoria createCurso(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
}
