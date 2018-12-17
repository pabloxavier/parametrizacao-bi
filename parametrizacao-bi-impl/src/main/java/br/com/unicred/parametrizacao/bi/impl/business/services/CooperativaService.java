package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.CooperativaDAO;

@Service
public class CooperativaService {

    private Logger log = LoggerFactory.getLogger(CooperativaService.class);
    private CooperativaDAO dao;
    
    @Autowired    
    public CooperativaService(CooperativaDAO dao) {
        this.dao = dao;
    }

    public List<Cooperativa> buscaCooperativas(final Boolean inAtivos) {
        List<Cooperativa> cooperativasList = dao.buscaCooperativas(inAtivos);
        if (cooperativasList.isEmpty()) {
          throw new NotFoundException("Nenhuma cooperativa foi encontrada.");
        }
        return cooperativasList;
    }

    public Cooperativa getCooperativaById(final Integer cdCoop) {
        Cooperativa coop = dao.getCooperativaById(cdCoop);
        if (null == coop) {
            throw new NotFoundException(String.format("Cooperativa %d não encontrada.", cdCoop));
        }
        return coop;
    }
}
