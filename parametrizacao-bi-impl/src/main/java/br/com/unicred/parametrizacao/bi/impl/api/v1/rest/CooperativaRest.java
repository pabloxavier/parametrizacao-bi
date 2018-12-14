package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.representation.CooperativaRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.converters.CooperativaConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RestExceptionHandler;
import br.com.unicred.parametrizacao.bi.impl.business.services.CooperativaService;
@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/cooperativa/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Cooperativa API")
public class CooperativaRest extends RestExceptionHandler{

    private CooperativaService cooperativaService;
    
    @Autowired
    public CooperativaRest(CooperativaService cooperativaService) {
        this.cooperativaService = cooperativaService;
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<CooperativaRepresentation>> listar(@RequestHeader(name = "Authorization") final String token,
                                                                  @RequestHeader(name = "apenasAtivos", required = false, defaultValue = "true") final Boolean inAtivos) {

        List<Cooperativa> comando = cooperativaService.buscaCooperativas(inAtivos);
        return ResponseEntity.ok(CooperativaConverter.from(comando));
    }
    
    @RequestMapping(value = "/pesquisar/{cooperativa}", method = RequestMethod.GET)
    public ResponseEntity<CooperativaRepresentation> getById(@RequestHeader(name = "Authorization") final String token,
                                                             @RequestHeader(name = "cooperativa") final Integer cooperativa) {
        
        Cooperativa comando = cooperativaService.getCooperativaById(cooperativa);
        return ResponseEntity.ok(CooperativaConverter.from(comando));
    }    
    
}
