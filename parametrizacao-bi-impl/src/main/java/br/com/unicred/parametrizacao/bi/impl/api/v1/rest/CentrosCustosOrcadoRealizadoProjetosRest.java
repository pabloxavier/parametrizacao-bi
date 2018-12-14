package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.representation.CentrosCustosOrcadoRealizadoProjetosRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.commands.CentrosCustosOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.converters.CentrosCustosOrcadoRealizadoProjetosConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.CentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.services.CentrosCustosOrcadoRealizadoProjetosService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="CENTROS-CUSTOS-ORCADO-REALIZADO-PROJETOS-API")
public class CentrosCustosOrcadoRealizadoProjetosRest {

    private CentrosCustosOrcadoRealizadoProjetosService serviceCentrosCustosOrcadoRealizadoProjetosService;

    @Autowired
    public CentrosCustosOrcadoRealizadoProjetosRest(CentrosCustosOrcadoRealizadoProjetosService serviceCentrosCustosOrcadoRealizadoProjetosService) {
        this.serviceCentrosCustosOrcadoRealizadoProjetosService = serviceCentrosCustosOrcadoRealizadoProjetosService;
    }

    @ApiOperation("value = Lista todos os centros de custo existentes")
    @GetMapping(path = "centros-custos-realizados-orcado-projetos/")
    public ResponseEntity<List<CentrosCustosOrcadoRealizadoProjetosRepresentation>> buscarTodos(@RequestHeader(name = "Authorization") final String token) {
        List<CentrosCustosOrcadoRealizadoProjetos> comando = serviceCentrosCustosOrcadoRealizadoProjetosService.buscarTodos();
        return ResponseEntity.ok(CentrosCustosOrcadoRealizadoProjetosConverter.from(comando));
    }

    @ApiOperation(value = "Salva novo centro custo orcado realizado por projeto")
    @PostMapping(path = "centros-custos-realizados-orcado-projetos/")
    public ResponseEntity<CentrosCustosOrcadoRealizadoProjetosRepresentation> salvarVinculoRenovacao(
            @RequestHeader("Authorization") String token,
            @RequestBody CentrosCustosOrcadoRealizadoProjetosCommand comando) {
        CentrosCustosOrcadoRealizadoProjetos domain = serviceCentrosCustosOrcadoRealizadoProjetosService.salvar(comando);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CentrosCustosOrcadoRealizadoProjetosConverter.from(domain));
    }

    
}

