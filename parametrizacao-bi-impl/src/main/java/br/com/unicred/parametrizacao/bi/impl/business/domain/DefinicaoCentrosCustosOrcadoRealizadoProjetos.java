package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand;

public class DefinicaoCentrosCustosOrcadoRealizadoProjetos {

    private Integer codigoCooperativa;
    private String comparacao;
    private String codigoPosto;    
    private Boolean excluir;
    
    protected DefinicaoCentrosCustosOrcadoRealizadoProjetos(){
        
    }
    
    private DefinicaoCentrosCustosOrcadoRealizadoProjetos(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando){
        this.codigoCooperativa = comando.getCodigoCooperativa();
        this.comparacao = comando.getComparacao();
        this.codigoPosto = comando.getCodigoPosto();
        this.excluir = Boolean.FALSE;
    }
    
    public static DefinicaoCentrosCustosOrcadoRealizadoProjetos criar(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando){
        return new DefinicaoCentrosCustosOrcadoRealizadoProjetos(comando);
    }

    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }

    public void setCodigoCooperativa(Integer codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }

    public String getComparacao() {
        return comparacao;
    }

    public void setComparacao(String comparacao) {
        this.comparacao = comparacao;
    }

    public String getCodigoPosto() {
        return codigoPosto;
    }

    public void setCodigoPosto(String codigoPosto) {
        this.codigoPosto = codigoPosto;
    }

    public Boolean getExcluir() {
        return excluir;
    }

    public void setExcluir(Boolean excluir) {
        this.excluir = excluir;
    }
}
