package com.coderhouse.entidades.auto;

import com.coderhouse.abstractas.Vehiculo;

public class Auto extends Vehiculo {

	@Override
	protected void encender() {
		System.out.println("Mi auto se enciende");

	}

	@Override
	protected void apagar() {
		System.out.println("Mi auto se apaga");

	}

	@Override
	protected void mover() {
		System.out.println("Mi auto se mueve");

	}

	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", ruedas=" + ruedas + "]";
	}
}

