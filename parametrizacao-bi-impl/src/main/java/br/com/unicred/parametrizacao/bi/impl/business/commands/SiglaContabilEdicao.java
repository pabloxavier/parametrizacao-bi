package br.com.unicred.parametrizacao.bi.api.v1.commands;

public class SiglaContabilEdicao {

	private String siglaContabil;
	private Integer ordem;
	
	protected SiglaContabilEdicao() {
		
	}
	
	public void validate() {
        //TODO realizar validacao
    }

	public String getSiglaContabil() {
		return siglaContabil;
	}

	public void setSiglaContabil(String siglaContabil) {
		this.siglaContabil = siglaContabil;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
	
	
	
	
}
