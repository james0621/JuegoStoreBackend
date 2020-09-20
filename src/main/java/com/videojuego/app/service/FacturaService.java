package com.videojuego.app.service;

import java.util.Date;
import java.util.List;

import javax.persistence.PrePersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videojuego.app.interfaceService.IfacturaService;
import com.videojuego.app.interfaces.IFactura;
import com.videojuego.app.modelo.Factura;

@Service
public class FacturaService implements IfacturaService{
	
	private Date date;
	
	@Autowired
	private IFactura data;
	
	@PrePersist()
	private void preConstruc() {
		this.date =  new Date();
	}
	
	@Override
	public List<Factura> listar() {
		return data.findAll();
	}

	@Override
	public Factura buscarPorId(Long id) {
		return data.findById(id);
	}

	@Override
	public Factura guardar(Factura factura) {
		factura.setFechaRegistro(date);
		return data.save(factura);
	}

	@Override
	public Factura eliminar(Long id) {
		Factura f = data.findById(id);
		if(f!= null) {
			data.delete(f);
		}
		
		return f;
	}

}
