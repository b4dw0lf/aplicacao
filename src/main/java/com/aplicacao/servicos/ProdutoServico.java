package com.aplicacao.servicos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao.dtos.ProdutoDto;
//import com.aplicacao.dtos.ProdutoDTO;
import com.aplicacao.entidades.Produto;
import  com.aplicacao.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorio Rep_Produto;

	public List<Produto> Listar() {
		return Rep_Produto.findAll();
	}

	public Produto Incluir(ProdutoDto produtoDto) throws Exception {

		Produto produto = new Produto();

		produto.setDescricao(produtoDto.getDescricao());
		produto.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());
		produto.setTipo(produtoDto.getTipo());
		produto.setValorFornecedor(produtoDto.getValorFornecedor());
		return Rep_Produto.save(produto);
	}

	public Produto Selecionar(long id) throws Exception {
		Produto viagem = Rep_Produto.findOne(id);

		if (viagem == null) {
			throw new Exception("Não existe esta viagem cadastrada");
		}
		return viagem;
	}
	
	public Produto Atualizar(ProdutoDto produtoDto) throws Exception{
		
		Produto produto = new Produto();
		
		produto.setCodigo(produtoDto.getCodigo());
		produto.setDescricao(produtoDto.getDescricao());
		produto.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());
		produto.setTipo(produtoDto.getTipo());
		produto.setValorFornecedor(produtoDto.getValorFornecedor());
		
		return Rep_Produto.save(produto);
	}
	
	public 
}
