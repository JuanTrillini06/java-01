package com.coderhouse;

import com.coderhouse.entidades.perro.Perro;

public class Main {

	public static void main(String[] args) {
		
		Perro miPerro = new Perro();
		
		System.out.println(miPerro);
		miPerro.setNombre("Lita");
		miPerro.comer();
		miPerro.dormir();
	}

}
