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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.aplicacao.entidades.Produto;
import com.aplicacao.servicos.ProdutoServico;

@RestController
@RequestMapping("/api/viagens")
public class ProdutoController  {
/*
	@Autowired
	private ProdutoServico SrvProduto;

	@PostMapping(path = "/new")
	public ResponseEntity<Produto> Cadastrar(@Valid(new ProdutorValidacao()) @RequestBody ViagemDto viagemDto, BindingResult result) {
		
		Response<Produto> response = new Response<Viagem>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Produto produtoSalvo = this.SrvProduto.alvar(viagemDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(viagemDto.getId())
				.toUri();
		response.setData(viagemSalva);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping
	public ResponseEntity<List<Produto>> listar() {
		List<Produto> viagens = SrvProduto.listar();
		return ResponseEntity.status(HttpStatus.OK).body(viagens);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Viagem>> buscar(@PathVariable("id") Long id) {
  
		Viagem viagem = viagemService.buscar(id);
		Response<Viagem> response = new Response<Viagem>();
		response.setData(viagem);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}*/
}