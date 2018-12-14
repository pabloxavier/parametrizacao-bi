package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.CooperativaDAO;

@Service
public class CooperativaService {

    private CooperativaDAO dao;
    
    @Autowired    
    public CooperativaService(CooperativaDAO dao) {
        this.dao = dao;
    }

    public List<Cooperativa> buscaCooperativas(final Boolean inAtivos) {
        return dao.buscaCooperativas(inAtivos);
    }

    public Cooperativa getCooperativaById(final Integer cooperativa) {
        return dao.getCooperativaById(cooperativa);
    }

}
