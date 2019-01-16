package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand;

public class DefinicaoCentrosCustosOrcadoRealizadoProjetos {

    private Integer codigoCooperativa;
    private String comparacao;
    private String codigoPosto;    
    private Boolean excluir;
    
    protected DefinicaoCentrosCustosOrcadoRealizadoProjetos(){
        
    }
    
    private DefinicaoCentrosCustosOrcadoRealizadoProjetos(Integer cdCoop, String comparacao, String cdPosto, Boolean isExcluido){
        this.codigoCooperativa = cdCoop;
        this.comparacao = comparacao;
        this.codigoPosto = cdPosto;
        this.excluir = isExcluido;
    }
    
    private DefinicaoCentrosCustosOrcadoRealizadoProjetos(Integer cdCoop, String comparacao, String cdPosto){
        this.codigoCooperativa = cdCoop;
        this.comparacao = comparacao;
        this.codigoPosto = cdPosto;
    }    
    
    public static DefinicaoCentrosCustosOrcadoRealizadoProjetos criar(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando){
        return new DefinicaoCentrosCustosOrcadoRealizadoProjetos(comando.getCodigoCooperativa(), comando.getComparacao(), comando.getCodigoPosto(), Boolean.FALSE);
    }
    
    public static DefinicaoCentrosCustosOrcadoRealizadoProjetos editar(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando){
        return new DefinicaoCentrosCustosOrcadoRealizadoProjetos(comando.getCodigoCooperativa(), comando.getComparacao(), comando.getCodigoPosto());
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
