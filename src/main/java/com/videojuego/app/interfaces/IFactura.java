package com.videojuego.app.interfaces;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.videojuego.app.modelo.Factura;


public interface IFactura extends Repository<Factura, Long>{
	List<Factura> findAll();
	Factura findById(Long id);
	Factura save(Factura factura);
	Factura delete(Factura factura);
}
