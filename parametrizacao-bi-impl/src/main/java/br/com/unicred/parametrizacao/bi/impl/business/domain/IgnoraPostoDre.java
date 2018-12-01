package br.com.unicred.parametrizacao.bi.impl.business.domain;

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
        
    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }
    public Integer getCodigoPosto() {
        return codigoPosto;
    }

    
    
}
