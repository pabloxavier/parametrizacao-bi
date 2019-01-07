package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.representation.ContasContabeisOrcadoRealizadoRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.commands.ContasContabeisOrcadoRealizadoCommand;
import br.com.unicred.parametrizacao.bi.impl.business.converters.ContasContabeisOrcadoRealizadoConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.ContasContabeisOrcadoRealizado;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RestExceptionHandler;
import br.com.unicred.parametrizacao.bi.impl.business.services.ContasContabeisOrcadoRealizadoService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/contasContabeisOrcadoRealizado/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Contas Contabeis Orcado Realizado API")
public class ContasContabeisOrcadoRealizadoRest extends RestExceptionHandler /*DefaultEndpoint*/ { //TODO

    private ContasContabeisOrcadoRealizadoService service;
    
    @Autowired
    public ContasContabeisOrcadoRealizadoRest(ContasContabeisOrcadoRealizadoService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<ContasContabeisOrcadoRealizadoRepresentation>> buscar(@RequestHeader("Authorization") final String token, 
                                                                                     @RequestHeader(name = "isProjeto", required = true, defaultValue = "false") final Boolean isProjeto) {
        List<ContasContabeisOrcadoRealizado> list = service.listarContasContabeisOrcadoRealizado(isProjeto);
        return ResponseEntity.ok(ContasContabeisOrcadoRealizadoConverter.from(list));
    }
    
    @RequestMapping(value = "/{cooperativa}", method = RequestMethod.GET)
    public ResponseEntity<List<ContasContabeisOrcadoRealizadoRepresentation>> pesquisar(@RequestHeader("Authorization") final String token,
                                                                                        @PathVariable("cooperativa") final Integer cdCoop, 
                                                                                        @RequestHeader(name = "isProjeto", required = true, defaultValue = "false") final Boolean isProjeto) {
        
        List<ContasContabeisOrcadoRealizado> list = service.listarContasContabeisOrcadoRealizadoByCoop(cdCoop, isProjeto);
        return ResponseEntity.ok(ContasContabeisOrcadoRealizadoConverter.from(list));
    }
    
    @RequestMapping(value = "/{cooperativa}/{conta}", method = RequestMethod.GET)
    public ResponseEntity<ContasContabeisOrcadoRealizadoRepresentation> filtrar(@RequestHeader("Authorization") final String token,
                                                                                @PathVariable("conta") final String cdConta, 
                                                                                @PathVariable("cooperativa") final Integer cdCoop, 
                                                                                @RequestHeader(name = "isProjeto", required = true, defaultValue = "false") final Boolean isProjeto) {
        
        ContasContabeisOrcadoRealizado result = service.buscaContaContabilOrcadoRealizadoByCoopAndConta(cdCoop, cdConta, isProjeto);
        return ResponseEntity.ok(ContasContabeisOrcadoRealizadoConverter.from(result));
    }    
    
    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<ContasContabeisOrcadoRealizadoRepresentation> inserir(@RequestHeader("Authorization") final String token,
                                                                                @RequestBody ContasContabeisOrcadoRealizadoCommand comando, 
                                                                                @RequestHeader(name = "isProjeto", required = true, defaultValue = "false") final Boolean isProjeto) {
        
        ContasContabeisOrcadoRealizado dominio = service.inserir(comando, isProjeto);
        return ResponseEntity.ok(ContasContabeisOrcadoRealizadoConverter.from(dominio));
    }
    
    @DeleteMapping(value = "/excluir")
    public ResponseEntity<?> excluir(@RequestHeader("Authorization") final String token,
                                     @RequestBody ContasContabeisOrcadoRealizadoCommand comando, 
                                     @RequestHeader(name = "isProjeto", required = true, defaultValue = "false") final Boolean isProjeto) {
        
        String mensagemExclusao = service.excluir(comando, isProjeto);
        return ResponseEntity.ok(mensagemExclusao);
    }
    
}
