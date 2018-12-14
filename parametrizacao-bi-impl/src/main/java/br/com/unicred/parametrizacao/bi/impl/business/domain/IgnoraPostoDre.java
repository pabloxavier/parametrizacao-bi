package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;

/**
 * 
 * As cooperativas fazem o rateio entre os postos, lançando valores de receita e 
 * despesa pelo posto 90 para retear conforme os critérios.
 * Porém, tem postos que não são mais utilizados então eles saem do rateio.
 * DRE = Demonstração do Resultado do Exercício
 *
 * @author thiago.cabelleira
 */
public class IgnoraPostoDre {
    
    private Integer codigoCooperativa;
    private Integer codigoPosto;
    
    protected IgnoraPostoDre(){
        
    }
    
    private IgnoraPostoDre(IgnoraPostoDreCommand comando){
        this.codigoCooperativa = comando.getCodigoCooperativa();
        this.codigoPosto = comando.getCodigoPosto();
    }
    
    public static IgnoraPostoDre criar(IgnoraPostoDreCommand comando){
        return new IgnoraPostoDre(comando);
    }

    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }

    public void setCodigoCooperativa(Integer codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }

    public Integer getCodigoPosto() {
        return codigoPosto;
    }

    public void setCodigoPosto(Integer codigoPosto) {
        this.codigoPosto = codigoPosto;
    }
    
}
