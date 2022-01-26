package com.aplicacao.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao.dtos.EstoqueDto;
import com.aplicacao.entidades.Estoque;
import com.aplicacao.repositorios.EstoqueRepositorio;

@Service
public class EstoqueServico {
	
	@Autowired
	private EstoqueRepositorio Rep_Estoque;

	public List<Estoque> Listar() {
		return Rep_Estoque.findAll();
	}

	public Estoque Incluir(EstoqueDto estoqueDto) throws Exception {

		Estoque estoque = new Estoque();

		estoque.setIdProduto(estoqueDto.getIdProduto());
		estoque.setTipoMov(estoqueDto.getTipoMov());
		estoque.setDtVenda(estoqueDto.getDtVenda());
		estoque.setVlVenda(estoqueDto.getVlVenda());
		estoque.setQtdMov(estoqueDto.getQtdMov());
		return Rep_Estoque.save(estoque);
	}

	public Estoque Selecionar(long id) throws Exception {
		Estoque Estoque = Rep_Estoque.getById(id);

		if (Estoque == null) {
			throw new Exception("Não existe essa movimentação cadastrado!");
		}
		
		return Estoque;
	}
	
	public Estoque Atualizar(EstoqueDto estoqueDto) throws Exception{
		
		Estoque estoque = new Estoque();
		
		estoque.setIdProduto(estoqueDto.getIdProduto());
		estoque.setTipoMov(estoqueDto.getTipoMov());
		estoque.setDtVenda(estoqueDto.getDtVenda());
		estoque.setVlVenda(estoqueDto.getVlVenda());
		estoque.setQtdMov(estoqueDto.getQtdMov());
		
		return Rep_Estoque.save(estoque);
	}
	
	public Estoque Excluir(long id) throws Exception {
		
		Estoque estoque = Rep_Estoque.getById(id);
		
		Rep_Estoque.delete(estoque);
		
		return estoque;
	}
}
