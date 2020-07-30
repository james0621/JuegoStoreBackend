package com.videojuego.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.videojuego.app.modelo.Cliente;

@Repository
public interface ICliente extends CrudRepository<Cliente, Long>{

}
