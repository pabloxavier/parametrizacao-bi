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
import br.com.unicred.parametrizacao.bi.impl.business.commands.PostoCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;
import br.com.unicred.parametrizacao.bi.impl.business.services.PostoService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/posto/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Posto API")
public class PostoRest {

    private PostoService postoService;
    
    @Autowired
    public PostoRest(PostoService postoService) {
        this.postoService = postoService;
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<PostoCommand>> buscar(@RequestHeader("Authorization") final String token) {
        List<PostoCommand> postoList = postoService.buscaPostos();
        
        for (PostoCommand posto : postoList) {
            System.out.println(posto.getNmPosto());
        }
        
        return ResponseEntity.ok(postoList);
    }
    
    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<Boolean> inserir(
            @RequestHeader("Authorization") final String token,
            @RequestBody Posto posto) {
        
        boolean success = postoService.inserirPosto(posto);
        
        return ResponseEntity.ok(success);
    }
    
}
