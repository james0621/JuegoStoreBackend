package com.videojuego.app.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="protagonista")
public class Protagonista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private VideoJuego videoJuego;
	
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
	public VideoJuego getVideoJuego() {
		return videoJuego;
	}
	public void setVideoJuego(VideoJuego videoJuego) {
		this.videoJuego = videoJuego;
	}
	
	
}
