package com.aplicacao.controladores;

import java.net.URI;
import java.util.ArrayList;
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

import com.aplicacao.dtos.TipoProdutoDto;
import com.aplicacao.entidades.TipoProduto;
import com.aplicacao.responses.Response;
import com.aplicacao.servicos.TipoProdutoServico;

@RestController
@RequestMapping("/api/tipo")
public class TipoProdutoController  {

	@Autowired
	private TipoProdutoServico SrvTipoProduto;
	
	/*
	public TipoProdutoController(){
				
		TipoProdutoDto novo = new TipoProdutoDto();
		novo.setDescricao("Eletrônico");
		Cadastrar(novo, null);
		
		novo = new TipoProdutoDto();
		novo.setDescricao("Eletrodoméstico");
		Cadastrar(novo, null);
		
		novo = new TipoProdutoDto();
		novo.setDescricao("Móvel");
		Cadastrar(novo, null);
	}*/

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Response<TipoProduto>> Cadastrar(@Valid @RequestBody TipoProdutoDto tipoProdutoDto, BindingResult result) {
		Response<TipoProduto> response = new Response<TipoProduto>();
		
		try {		
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			TipoProduto tipoSalvo = this.SrvTipoProduto.Incluir(tipoProdutoDto);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tipoProdutoDto.getCodigo()).toUri();
			
			response.setData(tipoSalvo);
			return ResponseEntity.created(location).body(response);
		}
		catch(Exception ex) {
			response.getErrors().add("Erro em TipoProdutoController:" + ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping(path = "/listar")
	public ResponseEntity<List<TipoProduto>> Listar() {
		
		List<TipoProduto> tipos = SrvTipoProduto.Listar();
		return ResponseEntity.status(HttpStatus.OK).body(tipos);
		
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<TipoProduto>> Selecionar(@PathVariable("id") Long id) {
  
		Response<TipoProduto> response = new Response<TipoProduto>();
		
		try {
			TipoProduto tipo = SrvTipoProduto.Selecionar(id);
			
			response.setData(tipo);
			
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch(Exception ex) {
			response.getErrors().add("Erro em ProdutoController:" + ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
}