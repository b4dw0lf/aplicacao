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
@Table(name = "Tipo")
public class TipoProduto implements Serializable{

	private static final long serialVersionUID = 238563936253436528L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Codigo")
	private long Codigo;
	@Column(name = "Descricao", nullable = false)
	private String Descricao;
	
	
	public TipoProduto() {

	}

	public TipoProduto(long Id, String Desc) {
		this.Codigo = Id;
		this.Descricao = Desc;
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
	
	
	@Override
	public String toString() {
		return "Produto [Codigo=" + Codigo + ", Descricao=" + Descricao + "]";
	}
}
