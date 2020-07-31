package com.videojuego.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.videojuego.app.modelo.Factura;

@Repository
public interface IFactura extends CrudRepository<Factura, Long>{

}
