package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.CooperativaCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.CooperativaDAO;

@Service
public class CooperativaService {

    @Autowired
    private CooperativaDAO dao;

    public List<CooperativaCommand> buscaCooperativas(final Integer cooperativa) {
        return dao.buscaCooperativas(cooperativa);
    }

    public boolean inserirCooperativa(Cooperativa cooperativa) {
        return dao.inserirCooperativa(cooperativa);
    }
}
