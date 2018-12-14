package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.representation.IgnoraPostoDreRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;
import br.com.unicred.parametrizacao.bi.impl.business.converters.IgnoraPostoDreConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.IgnoraPostoDre;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RestExceptionHandler;
import br.com.unicred.parametrizacao.bi.impl.business.services.IgnoraPostoDreService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/postosIgnoradosDre/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Posto Ignorados DRE API")
public class IgnoraPostoDreRest extends RestExceptionHandler /*DefaultEndpoint*/ { //TODO

    private IgnoraPostoDreService ignoraPostoDreService;
    
    @Autowired
    public IgnoraPostoDreRest(IgnoraPostoDreService ignoraPostoDreService) {
        this.ignoraPostoDreService = ignoraPostoDreService;
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<IgnoraPostoDreRepresentation>> buscar(@RequestHeader("Authorization") final String token) {
        List<IgnoraPostoDre> postosIgnoradosList = ignoraPostoDreService.buscaPostosIgnorados();
        return ResponseEntity.ok(IgnoraPostoDreConverter.from(postosIgnoradosList));
    }
    
    @RequestMapping(value = "/{cooperativa}", method = RequestMethod.GET)
    public ResponseEntity<List<IgnoraPostoDreRepresentation>> pesquisar(@RequestHeader("Authorization") final String token,
                                                                        @RequestHeader("cooperativa") final Integer cooperativa) {
        
        List<IgnoraPostoDre> postosIgnoradosList = ignoraPostoDreService.buscaPostosIgnoradosByCoop(cooperativa);
        return ResponseEntity.ok(IgnoraPostoDreConverter.from(postosIgnoradosList));
    }
    
    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<IgnoraPostoDreRepresentation> inserir(@RequestHeader("Authorization") final String token,
                                                                @RequestBody IgnoraPostoDreCommand ignoraPostoDreCommand) {
        
        IgnoraPostoDre dominio = ignoraPostoDreService.inserirPostoIgnorado(ignoraPostoDreCommand);
        return ResponseEntity.ok(IgnoraPostoDreConverter.from(dominio));
    }
    
    @DeleteMapping(value = "/excluir")
    public ResponseEntity<?> excluir(@RequestHeader("Authorization") final String token,
                                     @RequestBody IgnoraPostoDreCommand ignoraPostoDreCommand) {
        
        String mensagemExclusao = ignoraPostoDreService.excluirPostoIgnorado(ignoraPostoDreCommand);
        return ResponseEntity.ok(mensagemExclusao);
    }
    
}
