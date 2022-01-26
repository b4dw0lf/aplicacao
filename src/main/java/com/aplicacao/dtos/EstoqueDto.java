package com.aplicacao.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;

public class EstoqueDto implements Serializable {

	private static final long serialVersionUID = 7284433259537049306L;
	
	
	private long IdProduto;
	private String TipoMov;
	private double VlVenda;
	private Date DtVenda;
	private int QtdMov;
	
	public EstoqueDto() {

	}
	
	@Override
	public String toString() {
		return "Estoque [IdProduto=" + IdProduto + ", TipoMov=" + TipoMov + ", VlVenda=" + VlVenda
				+ ", DtVenda=" + DtVenda + ", QtdMov=" + QtdMov + "]";
	}

	@Required
	@NotNull(message = "Descrição é obrigatória")
	public long getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(long idProduto) {
		IdProduto = idProduto;
	}

	@Length(min = 1, max = 1, message = "Valores devem ser E ou S!")
	@Required
	@NotNull(message = "Tipo obrigatório")
	public String getTipoMov() {
		return TipoMov;
	}

	public void setTipoMov(String tipoMov) {
		TipoMov = tipoMov;
	}

	@DecimalMin(value = "0.01", message = "Valor mínimo é 0,01!")
	@Required
	@NotNull(message = "Valor obrigatório")
	public double getVlVenda() {
		return VlVenda;
	}

	public void setVlVenda(double vlVenda) {
		VlVenda = vlVenda;
	}

	@Required
	@NotNull(message = "Data obrigatória.")
	public Date getDtVenda() {
		return DtVenda;
	}

	public void setDtVenda(Date dtVenda) {
		DtVenda = dtVenda;
	}

	@Required
	@NotNull(message = "Quantidade é obrigatória")
	public int getQtdMov() {
		return QtdMov;
	}

	public void setQtdMov(int qtdMov) {
		QtdMov = qtdMov;
	}
}
