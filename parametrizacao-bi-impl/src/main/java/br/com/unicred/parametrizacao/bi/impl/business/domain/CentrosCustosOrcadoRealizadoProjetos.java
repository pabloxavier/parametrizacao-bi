package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.impl.business.commands.CentrosCustosOrcadoRealizadoProjetosCommand;

import java.util.Objects;

public class CentrosCustosOrcadoRealizadoProjetos {
    private Integer codigoCooperativa;
    private Integer codigoPosto;


    public CentrosCustosOrcadoRealizadoProjetos(CentrosCustosOrcadoRealizadoProjetosCommand command){
        this.codigoCooperativa = command.getCodigoCooperativa();
        this.codigoPosto = command.getCodigoPosto();
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

    public static CentrosCustosOrcadoRealizadoProjetos criar(CentrosCustosOrcadoRealizadoProjetosCommand command){
            return new CentrosCustosOrcadoRealizadoProjetos(command);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CentrosCustosOrcadoRealizadoProjetos)) return false;
        CentrosCustosOrcadoRealizadoProjetos that = (CentrosCustosOrcadoRealizadoProjetos) o;
        return Objects.equals(codigoCooperativa, that.codigoCooperativa) &&
                Objects.equals(codigoPosto, that.codigoPosto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCooperativa, codigoPosto);
    }

    @Override
    public String toString() {
        return "CentrosCustosOrcadoRealizadoProjetos{" +
                "codigoCooperativa=" + codigoCooperativa +
                ", codigoPosto=" + codigoPosto +
                '}';
    }
}
