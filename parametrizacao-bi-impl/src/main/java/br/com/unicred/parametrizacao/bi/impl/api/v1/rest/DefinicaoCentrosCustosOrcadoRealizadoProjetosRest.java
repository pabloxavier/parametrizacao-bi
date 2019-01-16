package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.representation.DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.converters.DefinicaoCentrosCustosOrcadoRealizadoProjetosConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoCentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RestExceptionHandler;
import br.com.unicred.parametrizacao.bi.impl.business.services.DefinicaoCentrosCustosOrcadoRealizadoProjetosService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/definicaoCentrosCustosOrcadoRealizadoProjetos/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Definicao Centros Custos Orcado Realizado Projetos API")
public class DefinicaoCentrosCustosOrcadoRealizadoProjetosRest extends RestExceptionHandler /*DefaultEndpoint*/ { //TODO

    private DefinicaoCentrosCustosOrcadoRealizadoProjetosService service;
    
    @Autowired
    public DefinicaoCentrosCustosOrcadoRealizadoProjetosRest(DefinicaoCentrosCustosOrcadoRealizadoProjetosService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation>> buscar(@RequestHeader("Authorization") final String token) {
        List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> list = service.listar();
        return ResponseEntity.ok(DefinicaoCentrosCustosOrcadoRealizadoProjetosConverter.from(list));
    }
    
    @RequestMapping(value = "/{cooperativa}/{comparacao}/{posto}/{excluir}", method = RequestMethod.GET)
    public ResponseEntity<List<DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation>> pesquisar(@RequestHeader("Authorization") final String token,
                                                                                                       @RequestHeader(name="cooperativa", required = false) Integer cdCoop,
                                                                                                       @RequestHeader(name="comparacao", required = false) String comparacao,
                                                                                                       @RequestHeader(name="posto", required = false) String cdPosto,
                                                                                                       @RequestHeader(name="isExcluido", required = false) final Boolean isExcluido) {
        
        List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> list = service.listarComFiltros(cdCoop, comparacao, cdPosto, isExcluido);
        return ResponseEntity.ok(DefinicaoCentrosCustosOrcadoRealizadoProjetosConverter.from(list));
    }
      
    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation> inserir(@RequestHeader("Authorization") final String token,
                                                                                @RequestBody DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        
        DefinicaoCentrosCustosOrcadoRealizadoProjetos dominio = service.inserir(comando);
        return ResponseEntity.ok(DefinicaoCentrosCustosOrcadoRealizadoProjetosConverter.from(dominio));
    }
    
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public ResponseEntity<DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation> editar(@RequestHeader("Authorization") final String token,
                                                                                              @RequestHeader(name="cooperativa", required = false) Integer cdCoop,
                                                                                              @RequestHeader(name="comparacao", required = false) String comparacao,
                                                                                              @RequestHeader(name="posto", required = false) String cdPosto,            
                                                                                              @RequestBody DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        
        DefinicaoCentrosCustosOrcadoRealizadoProjetos dominio = service.editar(cdCoop, comparacao, cdPosto, comando);
        return ResponseEntity.ok(DefinicaoCentrosCustosOrcadoRealizadoProjetosConverter.from(dominio));
    }    
    
    @DeleteMapping(value = "/excluir")
    public ResponseEntity<?> excluir(@RequestHeader("Authorization") final String token,
                                     @RequestBody DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        
        String mensagemExclusao = service.excluir(comando);
        return ResponseEntity.ok(mensagemExclusao);
    }
    
}
