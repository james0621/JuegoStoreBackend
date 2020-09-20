package com.videojuego.app.interfaces;



import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.videojuego.app.modelo.Juego;

public interface IJuego extends Repository<Juego, Long>{
	
	List<Juego> findAll();
	Juego findById(Long id);
	Juego save(Juego juego);
	Juego delete(Juego juego);
	
	@Query("SELECT j FROM Juego j WHERE j.nombre LIKE '%'|| :termino || '%'")
	List<Juego> buscarPorNombre(@Param("termino") String termino);
	
	@Modifying
	@Query("UPDATE Juego j SET j.cantidad = (j.cantidad-1) WHERE j.id = ?1")
	int actualizarCantidad(Long id);
}
