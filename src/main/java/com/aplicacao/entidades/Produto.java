package com.aplicacao.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 8557577346244608576L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Codigo")
	private long Codigo;
	@Column(name = "Descricao", nullable = false)
	private String Descricao;
	@Column(name = "TipoProduto", nullable = false, table = "TipoProduto")
	private int Tipo;
	@Column(name = "ValorFornecedor", nullable = false)
	private double ValorFornecedor;
	@Column(name = "QuantidadeEstoque", nullable = false)
	private int QuantidadeEstoque;
	
	
	public Produto() {

	}

	public Produto(long Id, String Desc, int Tipo, double Valor, int Qtd) {
		this.Codigo = Id;
		this.Descricao = Desc;
		this.Tipo = Tipo;
		this.ValorFornecedor = Valor;
		this.QuantidadeEstoque = Qtd;
	}
	
	public long getCodigo() {
		return Codigo;
	}
	public void setCodigo(long codigo) {
		Codigo = codigo;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public int getTipo() {
		return Tipo;
	}
	public void setTipo(int tipo) {
		Tipo = tipo;
	}
	public double getValorFornecedor() {
		return ValorFornecedor;
	}
	public void setValorFornecedor(double valorFornecedor) {
		ValorFornecedor = valorFornecedor;
	}
	public int getQuantidadeEstoque() {
		return QuantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		QuantidadeEstoque = quantidadeEstoque;
	}
	
	@Override
	public String toString() {
		return "Produto [Codigo=" + Codigo + ", Descricao=" + Descricao + ", Tipo=" + Tipo
				+ ", ValorFornecedor=" + ValorFornecedor + ", QuantidadeEstoque=" + QuantidadeEstoque + "]";
	}
}
