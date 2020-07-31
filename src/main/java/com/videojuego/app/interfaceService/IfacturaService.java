package com.videojuego.app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.videojuego.app.modelo.Factura;

public interface IfacturaService {
	
	public List<Factura> listar();
	public Optional<Factura> buscarPorId(Long id);
	public int guardar(Factura factura);
	public void eliminar(Long id);
}
