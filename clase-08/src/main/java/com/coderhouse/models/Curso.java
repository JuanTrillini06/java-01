package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
	private Long id;
	
	@Column(nullable = false, unique = true) // No sea nulo y es unico
	private String nombre;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
				name = "curso_alumno",
				joinColumns = @JoinColumn(name = "curso_id"),
				inverseJoinColumns = @JoinColumn(name = "alumno_id")
			)
	private List<Alumno> alumnos = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categorias;

	public Curso() {
		super();
	}

	public Curso(String nombre) {
		super();
		this.nombre = nombre;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Categoria getCategoria() {
		return categorias;
	}

	public void setCategoria(Categoria categoria) {
		this.categorias = categoria;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
}
