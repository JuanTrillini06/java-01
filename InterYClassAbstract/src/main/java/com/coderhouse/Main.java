package com.coderhouse;

import com.coderhouse.entidades.auto.Auto;
import com.coderhouse.entidades.gato.Gato;
import com.coderhouse.entidades.perro.Perro;

public class Main {

	public static void main(String[] args) {
		
		Perro miPerro = new Perro();
		
		System.out.println(miPerro);
		miPerro.setNombre("Firulay");
		miPerro.comer();
		miPerro.dormir();
		
		Gato miGato = new Gato();
		System.out.println(miGato);
		
		Auto ferrari = new Auto(0);
		
		ferrari.setMarca("Ferrai");
	    ferrari.setColor("Rojo");
		ferrari.setModelo("Testarosa");
		ferrari.setRuedas(4);

		System.out.println(ferrari);
		
		ferrari.mostrarCantidadDeRuedas();
	}

}
