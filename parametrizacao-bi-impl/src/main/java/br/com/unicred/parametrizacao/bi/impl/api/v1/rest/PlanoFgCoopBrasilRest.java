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
import br.com.unicred.parametrizacao.bi.api.v1.representation.PlanoFgCoopBrasilRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.commands.PlanoFgCoopBrasilCommand;
import br.com.unicred.parametrizacao.bi.impl.business.converters.PlanoFgCoopBrasilConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PlanoFgCoopBrasil;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RestExceptionHandler;
import br.com.unicred.parametrizacao.bi.impl.business.services.PlanoFgCoopBrasilService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/planoFgCoopBrasil/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Plano Fg Coop Brasil API")
public class PlanoFgCoopBrasilRest extends RestExceptionHandler {

    private PlanoFgCoopBrasilService planoFgCoopBrasilService;
    
    @Autowired
    public PlanoFgCoopBrasilRest(PlanoFgCoopBrasilService planoFgCoopBrasilService) {
        this.planoFgCoopBrasilService = planoFgCoopBrasilService;
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<PlanoFgCoopBrasilRepresentation>> buscar(@RequestHeader("Authorization") final String token) {
        List<PlanoFgCoopBrasil> planoFgCoopBrasilList = planoFgCoopBrasilService.buscaContaBacen();
        
        return ResponseEntity.ok(PlanoFgCoopBrasilConverter.from(planoFgCoopBrasilList));
    }
    
    @RequestMapping(value = "/{codigoContaBacen}", method = RequestMethod.GET)
    public ResponseEntity<List<PlanoFgCoopBrasilRepresentation>> pesquisar(@RequestHeader("Authorization") final String token,
                                                                        @RequestHeader("cooperativa") final String codigoContaBacen) {
        
        List<PlanoFgCoopBrasil> contasBacenList = planoFgCoopBrasilService.buscaContaBacenByCodigo(codigoContaBacen);
        return ResponseEntity.ok(PlanoFgCoopBrasilConverter.from(contasBacenList));
    }

    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<PlanoFgCoopBrasilRepresentation> inserir(@RequestHeader("Authorization") final String token,
            													   @RequestBody PlanoFgCoopBrasilCommand planoFgCoopBrasilCommand) {
        
        PlanoFgCoopBrasil dominio = planoFgCoopBrasilService.inserirContaBacen(planoFgCoopBrasilCommand);
        
        return ResponseEntity.ok(PlanoFgCoopBrasilConverter.from(dominio));
    }

}
