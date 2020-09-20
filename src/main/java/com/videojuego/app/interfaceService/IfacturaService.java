package com.videojuego.app.interfaceService;

import java.util.List;

import com.videojuego.app.modelo.Factura;

public interface IfacturaService {
	
	public List<Factura> listar();
	public Factura buscarPorId(Long id);
	public Factura guardar(Factura factura);
	public Factura eliminar(Long id);
}
