package com.aplicacao.servicos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao.dtos.ProdutoDto;
import com.aplicacao.entidades.Produto;
import com.aplicacao.repositorios.ProdutoRepositorio;

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
		Produto produto = Rep_Produto.getById(id);

		if (produto == null) {
			throw new Exception("Não existe este produto cadastrado!");
		}
		
		return produto;
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
	
	public Produto Excluir(ProdutoDto produtoDto) throws Exception {
		
		Produto produto = new Produto();

		produto.setCodigo(produtoDto.getCodigo());
		produto.setDescricao(produtoDto.getDescricao());
		produto.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());
		produto.setTipo(produtoDto.getTipo());
		produto.setValorFornecedor(produtoDto.getValorFornecedor());
		
		Rep_Produto.delete(produto);
		
		return produto;
	}
}
