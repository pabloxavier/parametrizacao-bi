package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PlanoFgCoopBrasilCommand;

public class PlanoFgCoopBrasil {

	private String codigoContaBacen;
	private String descricaoContaBacen;
	
	protected PlanoFgCoopBrasil() {
		
	}
	
	private PlanoFgCoopBrasil(PlanoFgCoopBrasilCommand comando) {
		this.codigoContaBacen = comando.getCodigoContaBacen();
		this.descricaoContaBacen = comando.getDescricaoContaBacen();
	}
	
	public static PlanoFgCoopBrasil criar(PlanoFgCoopBrasilCommand comando) {
		comando.validate();
		return new PlanoFgCoopBrasil(comando);
	}

	public String getCodigoContaBacen() {
		return codigoContaBacen;
	}

	public String getDescricaoContaBacen() {
		return descricaoContaBacen;
	}
	
	
}
