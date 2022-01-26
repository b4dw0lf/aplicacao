package com.aplicacao.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao.entidades.Estoque;

@Repository
public interface EstoqueRepositorio extends JpaRepository<Estoque, Long> {

	
}