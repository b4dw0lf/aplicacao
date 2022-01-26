package com.aplicacao.controladores;

import java.net.URI;
import java.util.List;

import javax.annotation.security.DenyAll;
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

import com.aplicacao.dtos.EstoqueDto;
import com.aplicacao.entidades.Estoque;
import com.aplicacao.responses.Response;
import com.aplicacao.servicos.EstoqueServico;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController  {

	@Autowired
	private EstoqueServico SrvEstoque;

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Response<Estoque>> Cadastrar(@Valid @RequestBody EstoqueDto estoqueDto, BindingResult result) {
		Response<Estoque> response = new Response<Estoque>();
		
		try {		
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			Estoque estoqueSalvo = this.SrvEstoque.Incluir(estoqueDto);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estoqueDto.getIdProduto()).toUri();
			response.setData(estoqueSalvo);
			return ResponseEntity.created(location).body(response);
		}
		catch(Exception ex) {
			response.getErrors().add("Erro em EstoqueController:" + ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping(path = "/listar")
	public ResponseEntity<List<Estoque>> Listar() {
		List<Estoque> Estoques = SrvEstoque.Listar();
		return ResponseEntity.status(HttpStatus.OK).body(Estoques);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Estoque>> Selecionar(@PathVariable("id") Long id) {
  
		Response<Estoque> response = new Response<Estoque>();
		
		try {
			Estoque Estoque = SrvEstoque.Selecionar(id);
			
			response.setData(Estoque);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch(Exception ex) {
			response.getErrors().add("Erro em EstoqueController:" + ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	
}