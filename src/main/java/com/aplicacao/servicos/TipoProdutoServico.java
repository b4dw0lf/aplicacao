package com.aplicacao.servicos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao.dtos.TipoProdutoDto;
import com.aplicacao.entidades.TipoProduto;
import com.aplicacao.repositorios.TipoProdutoRepositorio;

@Service
public class TipoProdutoServico {
	
	@Autowired
	private TipoProdutoRepositorio Rep_TipoProduto;

	public List<TipoProduto> Listar() {
		return Rep_TipoProduto.findAll();
	}

	public TipoProduto Incluir(TipoProdutoDto tipoProdutoDto) throws Exception {

		TipoProduto tipo = new TipoProduto();

		tipo.setDescricao(tipoProdutoDto.getDescricao());

		return Rep_TipoProduto.save(tipo);
	}

	public TipoProduto Selecionar(long id) throws Exception {
		TipoProduto tipo = Rep_TipoProduto.getById(id);

		if (tipo == null) {
			throw new Exception("Não existe este tipo de produto cadastrado!");
		}
		
		return tipo;
	}
	
	public TipoProduto Atualizar(TipoProdutoDto tipoProdutoDto) throws Exception{
		
		TipoProduto tipo = new TipoProduto();
		
		tipo.setCodigo(tipoProdutoDto.getCodigo());
		tipo.setDescricao(tipoProdutoDto.getDescricao());
		
		return Rep_TipoProduto.save(tipo);
	}
	
	public TipoProduto Excluir(TipoProdutoDto tipoProdutoDto) throws Exception {
		
		TipoProduto tipo = new TipoProduto();

		tipo.setCodigo(tipoProdutoDto.getCodigo());
		tipo.setDescricao(tipoProdutoDto.getDescricao());

		Rep_TipoProduto.delete(tipo);
		
		return tipo;
	}
}
