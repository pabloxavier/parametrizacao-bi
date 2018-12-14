package br.com.unicred.parametrizacao.bi.impl.business.services;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Indicador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.IndicadorDAO;

import java.util.List;

@Service
public class IndicadorService {

    @Autowired
    private IndicadorDAO dao;

    public List<Indicador> buscaIndicadores() {
        return dao.buscaIndicadores();
    }
}
