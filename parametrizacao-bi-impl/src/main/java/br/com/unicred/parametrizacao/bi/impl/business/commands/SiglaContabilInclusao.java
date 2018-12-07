package br.com.unicred.parametrizacao.bi.api.v1.commands;

public class SiglaContabilInclusao {
	
	private Integer codigo;
	private String siglaContabil;
	private Integer ordem;
	
	protected SiglaContabilInclusao() {
		
	}
	
	public void validate() {
        //TODO realizar validacao
    }

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
