package com.videojuego.app.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="factura")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@OneToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="ID_VIDEOJUEGO")
	private Juego juego;
	
	private Date fechaVencimiento;
	
	private Date fechaGarantia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Juego getJuego() {
		return juego;
	}
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaGarantia() {
		return fechaGarantia;
	}
	public void setFechaGarantia(Date fechaGarantia) {
		this.fechaGarantia = fechaGarantia;
	}
	
	

}
