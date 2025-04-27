package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CrudInterface;
import com.coderhouse.models.Categoria;
import com.coderhouse.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaServicio implements CrudInterface<Categoria, Long> {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Categoria no encontrada"));
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoriaNuevo) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoriaNuevo);
	}

	@Override
	@Transactional
	public Categoria update(Long id, Categoria categoriaActualizado) {
		Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Categoria no encontrada"));
		
		if(categoriaActualizado.getNombre() != null && !categoriaActualizado.getNombre().isEmpty()) {
			categoria.setNombre(categoriaActualizado.getNombre());
		}
		
		return categoriaRepository.save(categoria);
	}

	@Override
	public void deleteById(Long id) {
		if(!categoriaRepository.existsById(id)) {
			throw new IllegalArgumentException("Curso no encontrado");
		}
		categoriaRepository.deleteById(id);	
	}

}
