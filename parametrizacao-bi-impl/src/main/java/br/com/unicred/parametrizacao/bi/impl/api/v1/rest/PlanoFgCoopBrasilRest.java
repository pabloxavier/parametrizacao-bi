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
import br.com.unicred.parametrizacao.bi.impl.business.commands.PlanoFgCoopBrasilCommand;
import br.com.unicred.parametrizacao.bi.impl.business.services.PlanoFgCoopBrasilService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/planoFgCoopBrasil/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Plano Fg Coop Brasil API")
public class PlanoFgCoopBrasilRest {

    private PlanoFgCoopBrasilService planoFgCoopBrasilService;
    
    @Autowired
    public PlanoFgCoopBrasilRest(PlanoFgCoopBrasilService planoFgCoopBrasilService) {
        this.planoFgCoopBrasilService = planoFgCoopBrasilService;
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<PlanoFgCoopBrasilCommand>> buscar(@RequestHeader("Authorization") final String token) {
        List<PlanoFgCoopBrasilCommand> planoFgCoopBrasilList = planoFgCoopBrasilService.buscaContaBacen();
        
        for (PlanoFgCoopBrasilCommand planoFg : planoFgCoopBrasilList) {
            System.out.println(planoFg.getDescricaoContaBacen());
        }
        
        return ResponseEntity.ok(planoFgCoopBrasilList);
    }

}
