package br.com.unicred.parametrizacao.bi.impl.business.commands;

public class PlanoFgCoopBrasilCommand {
	
	private String codigoContaBacen;
	private String descricaoContaBacen;

	public PlanoFgCoopBrasilCommand() {
		
	}
	
	public void validate() {
		//se tiver validacao fazer
	}

	public String getCodigoContaBacen() {
		return codigoContaBacen;
	}

	public void setCodigoContaBacen(String codigoContaBacen) {
		this.codigoContaBacen = codigoContaBacen;
	}

	public String getDescricaoContaBacen() {
		return descricaoContaBacen;
	}

	public void setDescricaoContaBacen(String descricaoContaBacen) {
		this.descricaoContaBacen = descricaoContaBacen;
	}
	
}

