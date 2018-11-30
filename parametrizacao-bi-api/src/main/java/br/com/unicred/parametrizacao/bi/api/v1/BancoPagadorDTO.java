package br.com.unicred.parametrizacao.bi.api.v1;

import java.io.Serializable;
import java.util.List;

public class BancoPagadorDTO implements Serializable {

	private static final long serialVersionUID = 2225295155237966392L;
	private Integer cdTributo;
	private Integer cdBanco;
	private List<String> criticas;
	private Integer cooperativa;
	private Character tipoTributo;

	public Integer getCdTributo() {
		return cdTributo;
	}

	public void setCdTributo(Integer cdTributo) {
		this.cdTributo = cdTributo;
	}

	public Integer getCdBanco() {
		return cdBanco;
	}

	public void setCdBanco(Integer cdBanco) {
		this.cdBanco = cdBanco;
	}

	public List<String> getCriticas() {
		return criticas;
	}

	public void setCriticas(List<String> criticas) {
		this.criticas = criticas;
	}

	public Integer getCooperativa() {
		return cooperativa;
	}

	public void setCooperativa(Integer cooperativa) {
		this.cooperativa = cooperativa;
	}

	public Character getTipoTributo() {
		return tipoTributo;
	}

	public void setTipoTributo(Character tipoTributo) {
		this.tipoTributo = tipoTributo;
	}

}
