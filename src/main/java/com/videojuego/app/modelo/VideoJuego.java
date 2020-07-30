package com.videojuego.app.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "videojuego")
public class VideoJuego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long año;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "videoJuego")
	private List<Protagonista> protagonistas;
	private String director;
	private String productor;
	private String tecnologia;
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
	public String getTecnologia() {
		return tecnologia;
	}
	public void setConsolas(String tecnologia) {
		this.tecnologia = tecnologia;
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
