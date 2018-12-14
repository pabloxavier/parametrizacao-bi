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
import br.com.unicred.parametrizacao.bi.api.v1.representation.PostoRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.converters.PostoConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RestExceptionHandler;
import br.com.unicred.parametrizacao.bi.impl.business.services.PostoService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/posto/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Posto API")
public class PostoRest  extends RestExceptionHandler{

    private PostoService postoService;
    
    @Autowired
    public PostoRest(PostoService postoService) {
        this.postoService = postoService;
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<PostoRepresentation>> listar(@RequestHeader(name = "Authorization") final String token,
                                                            @RequestHeader(name = "cooperativa", required = false) final Integer cooperativa,
                                                            @RequestHeader(name = "posto", required = false) final Integer posto,
                                                            @RequestHeader(name = "apenasAtivos", required = false, defaultValue = "true") final Boolean inAtivos) {

        List<Posto> postoList = postoService.buscaPostos(cooperativa, posto, inAtivos);        
        return ResponseEntity.ok(PostoConverter.from(postoList));
    }
    
    @RequestMapping(value = "/pesquisar/{cooperativa}/{posto}", method = RequestMethod.GET)
    public ResponseEntity<PostoRepresentation> getById(@RequestHeader(name = "Authorization") final String token,
                                                       @RequestHeader(name = "cooperativa") final Integer cooperativa,            
                                                       @RequestHeader(name = "posto") final Integer posto) {
        
        Posto postoFind = postoService.getPostoById(cooperativa, posto);
        return ResponseEntity.ok(PostoConverter.from(postoFind));
    }   
    
}
