package com.videojuego.app.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.videojuego.app.modelo.Cliente;

public interface ICliente extends Repository<Cliente, Long>{
	
	List<Cliente> findAll();
	Cliente findById(Long id);
	Cliente save(Cliente cliente);
	Cliente delete(Cliente cliente);
	
	@Query("SELECT c FROM Cliente c WHERE c.documento = ?1")
	Cliente buscarPorDocumento(Long documento);
}
