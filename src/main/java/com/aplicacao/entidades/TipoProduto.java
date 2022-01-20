package com.aplicacao.entidades;

public enum TipoProduto {
	
	ELETRONICO("Eletrônico"),
	ELETRODOMESTICO("Eletrodoméstico"),
	MOVEL("Móvel");
	
	private String descricao;

    private TipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
