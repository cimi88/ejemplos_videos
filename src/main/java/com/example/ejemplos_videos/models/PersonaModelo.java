package com.example.ejemplos_videos.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class PersonaModelo {
	private int idPersona;
	private String nombre;
	
	@Min(0) @Max(100)
	private int edad;
	@Min(0) @Max(300)
	private float peso;
	
	private String pais;

	public PersonaModelo() {
	}

	public PersonaModelo(int idPersona, String nombre, int edad, float peso, String pais) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
	}

	public int getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "PersonaModelo [idPersona=" + idPersona + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", pais=" + pais + "]";
	}
}
