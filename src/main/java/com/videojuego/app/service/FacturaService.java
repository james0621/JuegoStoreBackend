package com.videojuego.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.videojuego.app.interfaceService.IfacturaService;
import com.videojuego.app.interfaces.IFactura;
import com.videojuego.app.modelo.Factura;

public class FacturaService implements IfacturaService{

	@Autowired
	private IFactura data;
	
	@Override
	public List<Factura> listar() {
		return (List<Factura>)data.findAll();
	}

	@Override
	public Optional<Factura> buscarPorId(Long id) {
		return data.findById(id);
	}

	@Override
	public int guardar(Factura factura) {
		int resp = 0;
		Factura f = data.save(factura);
		if(f != null) {
			resp = 1;
		}
		return resp;
	}

	@Override
	public void eliminar(Long id) {
		data.deleteById(id);
	}

}
