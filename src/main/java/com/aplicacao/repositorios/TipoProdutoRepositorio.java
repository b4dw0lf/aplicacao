package com.aplicacao.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao.entidades.TipoProduto;

@Repository
public interface TipoProdutoRepositorio extends JpaRepository<TipoProduto, Long> {

	
}