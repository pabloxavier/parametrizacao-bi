package br.com.unicred.parametrizacao.bi.impl.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.IndicadorDAO;

@Service
public class IndicadorService {

    @Autowired
    private IndicadorDAO dao;

}
