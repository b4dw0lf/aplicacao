package com.aplicacao.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao.entidades.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

	Produto findByDescricao(String Descricao);
}