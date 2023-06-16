package com.example.ejemplos_videos.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	
	private String nombre;
	private int edad;
	private float peso;
	private String pais;
	
	@Column(name="creado") @CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="actualizado") @UpdateTimestamp
	private LocalDateTime updatedAt;

	public Persona() {
	}

	public Persona(int idPersona, String nombre, int edad, float peso, String pais) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.pais = pais;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
