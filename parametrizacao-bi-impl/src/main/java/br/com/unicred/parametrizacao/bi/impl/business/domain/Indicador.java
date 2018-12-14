package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.impl.business.converters.PeriodicidadeConverter;
import br.com.unicred.parametrizacao.bi.impl.business.dto.IndicadorDTO;

public class Indicador {

    private Integer codigo;
    private String nome;
    private Periodicidade periodicidade;

    public static Indicador create(IndicadorDTO indicadorDTO) {
        Indicador indicador = new Indicador();
        indicador.codigo = indicadorDTO.getChave();
        indicador.nome = indicadorDTO.getNomeIndicador();
        indicador.periodicidade = PeriodicidadeConverter.convertToEnum(indicadorDTO.getPeriodicidade());
        return indicador;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Periodicidade getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Periodicidade periodicidade) {
        this.periodicidade = periodicidade;
    }

}
