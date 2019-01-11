package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.CooperativaDAO;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.utils.Constants;

@Service
public class CooperativaService {

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

    public Cooperativa getCooperativaById(final Integer cdCoop, Boolean isValidacao) {
        Cooperativa coop = dao.getCooperativaById(cdCoop);
        if (null == coop && cdCoop != Constants.COOP_UBR) {
            throw new NotFoundException(String.format("Cooperativa %d não encontrada.", cdCoop));
        }
        return coop;
    }
}
