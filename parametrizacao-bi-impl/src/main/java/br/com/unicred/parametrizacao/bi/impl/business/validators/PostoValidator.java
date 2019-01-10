package br.com.unicred.parametrizacao.bi.impl.business.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unicred.parametrizacao.bi.impl.business.services.PostoService;

@Component
public class PostoValidator {
    
    private PostoService service;
    
    @Autowired    
    public PostoValidator(PostoService service) {
        this.service = service;
    }

    public void existePosto(final Integer cdCoop, final Integer cdPosto) {
        service.getPostoById(cdCoop, cdPosto, Boolean.TRUE);
    }


}
