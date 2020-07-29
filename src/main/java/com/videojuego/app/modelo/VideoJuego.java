package com.videojuego.app.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videojuego")
public class VideoJuego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long año;
	private List<Protagonista> protagonistas;
	private String director;
	private String productor;
	private List<Consola> consolas;
	private Double precioVenta;
	private Double precioAlquiler;
	
	
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
	public Long getAño() {
		return año;
	}
	public void setAño(Long año) {
		this.año = año;
	}
	public List<Protagonista> getProtagonistas() {
		return protagonistas;
	}
	public void setProtagonistas(List<Protagonista> protagonistas) {
		this.protagonistas = protagonistas;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProductor() {
		return productor;
	}
	public void setProductor(String productor) {
		this.productor = productor;
	}
	public List<Consola> getConsolas() {
		return consolas;
	}
	public void setConsolas(List<Consola> consolas) {
		this.consolas = consolas;
	}
	public Double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public Double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(Double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	
	
}
