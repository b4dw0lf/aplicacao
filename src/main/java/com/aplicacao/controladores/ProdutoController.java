package com.aplicacao.controladores;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aplicacao.dtos.ProdutoDto;
import com.aplicacao.entidades.Produto;
import com.aplicacao.responses.Response;
import com.aplicacao.servicos.ProdutoServico;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController  {

	@Autowired
	private ProdutoServico SrvProduto;

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Response<Produto>> Cadastrar(@Valid @RequestBody ProdutoDto produtoDto, BindingResult result) {
		Response<Produto> response = new Response<Produto>();
		
		try {		
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			Produto produtoSalvo = this.SrvProduto.Incluir(produtoDto);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtoDto.getCodigo()).toUri();
			response.setData(produtoSalvo);
			return ResponseEntity.created(location).body(response);
		}
		catch(Exception ex) {
			response.getErrors().add("Erro em ProdutoController:" + ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping(path = "/listar")
	public ResponseEntity<List<Produto>> Listar() {
		List<Produto> produtos = SrvProduto.Listar();
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Produto>> Selecionar(@PathVariable("id") Long id) {
  
		Response<Produto> response = new Response<Produto>();
		
		try {
			Produto produto = SrvProduto.Selecionar(id);
			
			response.setData(produto);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch(Exception ex) {
			response.getErrors().add("Erro em ProdutoController:" + ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
}