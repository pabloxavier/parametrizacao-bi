package br.com.unicred.parametrizacao.bi.impl.business.commands;

import java.util.Objects;

public class CentrosCustosOrcadoRealizadoProjetosCommand {

    private Integer codigoCooperativa;
    private Integer codigoPosto;

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
