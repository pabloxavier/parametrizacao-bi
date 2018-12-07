package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.IgnoraPostoDreDAO;

@Service
public class IgnoraPostoDreService {

    @Autowired
    private IgnoraPostoDreDAO dao;

    public boolean existsDECUnicredParaCooperativa(final Integer cooperativa) {
        return dao.existsDECUnicred(cooperativa);
    }
    
    public List<IgnoraPostoDreCommand> buscaIgnoraPostoDre(final Integer cooperativa) {
        return dao.buscaIgnoraPostoDre(cooperativa);
    }

}
