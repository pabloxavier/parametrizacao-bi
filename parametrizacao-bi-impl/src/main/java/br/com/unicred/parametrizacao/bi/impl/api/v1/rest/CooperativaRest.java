package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.impl.business.commands.CooperativaCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;
import br.com.unicred.parametrizacao.bi.impl.business.services.CooperativaService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/cooperativa/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Cooperativa API")
public class CooperativaRest {

    private CooperativaService cooperativaService;
    
    @Autowired
    public CooperativaRest(CooperativaService cooperativaService) {
        this.cooperativaService = cooperativaService;
    }
    
    @RequestMapping(value = "/listar'", method = RequestMethod.GET)
    public ResponseEntity<List<CooperativaCommand>> buscar(@RequestHeader("Authorization") final String token) {
        List<CooperativaCommand> coops = cooperativaService.buscaCooperativas();
        return ResponseEntity.ok(coops);
    }
    
    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<Boolean> inserir(
            @RequestHeader("cooperativa") final Integer coop, 
            @RequestHeader("Authorization") final String token,
            @RequestBody Cooperativa cooperativa) {
        
        boolean success = cooperativaService.inserirCooperativa(cooperativa);
        
        return ResponseEntity.ok(success);
    }
    
}
