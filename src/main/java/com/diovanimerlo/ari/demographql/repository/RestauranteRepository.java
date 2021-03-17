package com.diovanimerlo.ari.demographql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diovanimerlo.ari.demographql.domain.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
	
	public Optional<Restaurante> findByCnpj(String cnpj);
}
