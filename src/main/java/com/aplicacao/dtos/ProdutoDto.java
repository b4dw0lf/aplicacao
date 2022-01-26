package com.aplicacao.dtos;

import java.io.Serializable;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ProdutoDto implements Serializable {

	private static final long serialVersionUID = 8493126628599071440L;
		
	private long Codigo;
	private String Descricao;
	private int Tipo;
	private double ValorFornecedor;
	private int QuantidadeEstoque;
	
	public ProdutoDto() {

	}
	
	@Override
	public String toString() {
		return "ProdutoDto [Codigo=" + Codigo + ", Descricao=" + Descricao + ", Tipo=" + Tipo
				+ ", ValorFornecedor=" + ValorFornecedor + ", QuantidadeEstoque=" + QuantidadeEstoque + "]";
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
	
	@NotNull(message = "Tipo é obrigatório")
	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}

	@NotNull(message = "Valor do Fornecedor é obrigatório")
	@DecimalMin(value = "0.01")
	public double getValorFornecedor() {
		return ValorFornecedor;
	}

	public void setValorFornecedor(double valorFornecedor) {
		ValorFornecedor = valorFornecedor;
	}

	@NotNull(message = "Quantidade em estoque é obrigatório")
	@Min(value = 0)
	public int getQuantidadeEstoque() {
		return QuantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		QuantidadeEstoque = quantidadeEstoque;
	}
}
