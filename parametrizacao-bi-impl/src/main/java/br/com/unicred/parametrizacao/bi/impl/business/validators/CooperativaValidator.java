package br.com.unicred.parametrizacao.bi.impl.business.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unicred.parametrizacao.bi.impl.business.services.CooperativaService;

@Component
public class CooperativaValidator {
    
    private CooperativaService service;
    
    @Autowired    
    public CooperativaValidator(CooperativaService service) {
        this.service = service;
    }

    public void existeCoop(final Integer cdCoop) {
        service.getCooperativaById(cdCoop, Boolean.TRUE);
    }


}
