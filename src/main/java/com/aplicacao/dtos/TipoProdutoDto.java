package com.aplicacao.dtos;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;

public class TipoProdutoDto implements Serializable {

	private static final long serialVersionUID = 2510257319935811024L;

	private long Codigo;
	private String Descricao;
	
	public TipoProdutoDto() {

	}
	
	@Override
	public String toString() {
		return "ProdutoDto [Codigo=" + Codigo + ", Descricao=" + Descricao +  "]";
	}

	public long getCodigo() {
		return Codigo;
	}

	public void setCodigo(long codigo) {
		Codigo = codigo;
	}

	@NotNull(message = "Descrição é obrigatória")
	@NotEmpty(message = "Descrição é obrigatória")
	@Length(min = 5, message = "Descrição deve ser maior que 5 caracteres")
	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
}
