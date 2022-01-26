package com.aplicacao.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "estoque")
public class Estoque implements Serializable{

	private static final long serialVersionUID = -2947414831825832105L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdProduto", nullable = false)
	private long IdProduto;
	@Column(name = "TipoMov", nullable = false)
	private String TipoMov;
	@Column(name = "VlVenda", nullable = false)
	private double VlVenda;
	@Column(name = "DtVenda", nullable = false)
	private Date DtVenda;
	@Column(name = "QtdMov", nullable = false)
	private int QtdMov;
	
	public Estoque() {

	}
	
	public long getIdProduto() {
		return IdProduto;
	}
	public void setIdProduto(long produto) {
		IdProduto = produto;
	}
	public String getTipoMov() {
		return TipoMov;
	}
	public void setTipoMov(String tipoMov) {
		TipoMov = tipoMov;
	}
	public double getVlVenda() {
		return VlVenda;
	}
	public void setVlVenda(double vlVenda) {
		VlVenda = vlVenda;
	}
	public Date getDtVenda() {
		return DtVenda;
	}
	public void setDtVenda(Date dtVenda) {
		DtVenda = dtVenda;
	}
	public int getQtdMov() {
		return QtdMov;
	}
	public void setQtdMov(int qtdMov) {
		QtdMov = qtdMov;
	}
	
	@Override
	public String toString() {
		return "Estoque [IdProduto=" + IdProduto + ", TipoMov=" + TipoMov + ", VlVenda=" + VlVenda
				+ ", DtVenda=" + DtVenda + ", QtdMov=" + QtdMov + "]";
	}

}