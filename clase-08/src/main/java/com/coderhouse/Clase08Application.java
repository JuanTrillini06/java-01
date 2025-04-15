package com.coderhouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Alumno;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Curso;

@SpringBootApplication
public class Clase08Application implements CommandLineRunner{
	
	@Autowired
	private DaoFactory dao;
	
	public static void main(String[] args) {
		SpringApplication.run(Clase08Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {		
			
			Categoria categoria1 = new Categoria("Programacion FrontEnd");
			Categoria categoria2 = new Categoria("Programacion BackEnd");
			Categoria categoria3 = new Categoria("Programacion Data science");
			
			Curso curso1 = new Curso("Java"); //Back
			Curso curso2 = new Curso("JavaScript"); //Front
			Curso curso3 = new Curso("React"); //Front
			Curso curso4 = new Curso("Angular"); //Front
			Curso curso5 = new Curso("SQL"); // Data
			Curso curso6 = new Curso("MongoDB"); // Data
			
			Alumno alumno1 = new Alumno("Alejandro", "Di Stefano", 22333666, "L22333666", 49);
			Alumno alumno2 = new Alumno("Juan", "Trillini", 33555888, "L33555888", 23);
			Alumno alumno3 = new Alumno("Octavio", "Conrero", 44222666, "L44222666", 23);
			Alumno alumno4 = new Alumno("Felipe", "Ceballos", 77999444, "L77999444", 23);
			Alumno alumno5 = new Alumno("Jeronimo", "Carrillo", 11555777, "L11555777", 21);
			/*
			dao.persistirCategoria(categoria1);
			dao.persistirCategoria(categoria2);
			dao.persistirCategoria(categoria3);
			
			dao.persistirCurso(curso1);
			dao.persistirCurso(curso2);
			dao.persistirCurso(curso3);
			dao.persistirCurso(curso4);
			dao.persistirCurso(curso5);
			dao.persistirCurso(curso6);
			
			dao.persistirAlumno(alumno1);
			dao.persistirAlumno(alumno2);
			dao.persistirAlumno(alumno3);
			dao.persistirAlumno(alumno4);
			dao.persistirAlumno(alumno5);
			
			dao.asignarCategoriaCurso(curso1.getId(), categoria2.getId() );
			dao.asignarCategoriaCurso(curso2.getId(), categoria1.getId() );
			dao.asignarCategoriaCurso(curso3.getId(), categoria2.getId() );
			dao.asignarCategoriaCurso(curso4.getId(), categoria2.getId() );
			dao.asignarCategoriaCurso(curso5.getId(), categoria3.getId() );
			dao.asignarCategoriaCurso(curso6.getId(), categoria3.getId() );
			*/
		
			
			List<Long> cursosIdParaAlumno1 = new ArrayList<>();
					cursosIdParaAlumno1.add(curso1.getId());
					cursosIdParaAlumno1.add(curso2.getId());
					cursosIdParaAlumno1.add(curso5.getId());
					
			dao.inscribirAUnAlumnoEnUnCursoOEnVariosCursos(alumno1.getId(), cursosIdParaAlumno1);
			
			
			
		}catch(Exception err) {
			err.printStackTrace(System.err);
		}
		
		
	}

}
