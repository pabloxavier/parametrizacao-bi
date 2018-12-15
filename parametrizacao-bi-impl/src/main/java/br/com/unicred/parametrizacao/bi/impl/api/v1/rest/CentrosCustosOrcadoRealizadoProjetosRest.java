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

    @ApiOperation(value = "Lista todos os centros de custo orçado realizado projetos existentes")
    @GetMapping(path = "centros-custos-realizados-orcado-projetos/")
    public ResponseEntity<List<CentrosCustosOrcadoRealizadoProjetosRepresentation>> buscarTodos(@RequestHeader(name = "Authorization") final String token) {
        List<CentrosCustosOrcadoRealizadoProjetos> comando = serviceCentrosCustosOrcadoRealizadoProjetosService.buscarTodos();
        return ResponseEntity.ok(CentrosCustosOrcadoRealizadoProjetosConverter.from(comando));
    }

    @ApiOperation(value = "Lista todos os centros de custo existentes por cooperativa")
    @GetMapping(path = "centros-custos-realizados-orcado-projetos/{cooperativa}/postos")
    public ResponseEntity<List<CentrosCustosOrcadoRealizadoProjetosRepresentation>> buscarPorCooperativa(@RequestHeader(name = "Authorization") final String token,
                                                                                                         @PathVariable(value = "cooperativa", required = true) final Integer cooperativa) {
        List<CentrosCustosOrcadoRealizadoProjetos> comando =
                serviceCentrosCustosOrcadoRealizadoProjetosService.buscarPorCooperativa(cooperativa);
        return ResponseEntity.ok(CentrosCustosOrcadoRealizadoProjetosConverter.from(comando));
    }

    @ApiOperation(value = "Lista todos os centros de custo existentes por posto")
    @GetMapping(path = "centros-custos-realizados-orcado-projetos/{posto}/cooperativas")
    public ResponseEntity<List<CentrosCustosOrcadoRealizadoProjetosRepresentation>> buscarPorPosto(@RequestHeader(name = "Authorization") final String token,
                                                                                                   @PathVariable(value = "posto", required = true) final Integer posto) {
        List<CentrosCustosOrcadoRealizadoProjetos> comando =
                serviceCentrosCustosOrcadoRealizadoProjetosService.buscarPorPosto(posto);
        return ResponseEntity.ok(CentrosCustosOrcadoRealizadoProjetosConverter.from(comando));
    }

    @ApiOperation(value = "Lista o centro de custo existente por cooperativa e posto")
    @GetMapping(path = "centros-custos-realizados-orcado-projetos/pesquisar/")
    public ResponseEntity<CentrosCustosOrcadoRealizadoProjetosRepresentation> buscarPorCooperativaEPosto(@RequestHeader(name = "Authorization") final String token,
                                                                                                         @RequestParam(required = true, value = "codigoCooperativa") final Integer cooperativa,
                                                                                                         @RequestParam(required = true, value = "codigoPosto") final Integer posto) {
        CentrosCustosOrcadoRealizadoProjetos comando =
                serviceCentrosCustosOrcadoRealizadoProjetosService.buscarPorCooperativaEPosto(cooperativa, posto);
        return ResponseEntity.ok(CentrosCustosOrcadoRealizadoProjetosConverter.from(comando));
    }

    @ApiOperation(value = "Cria novo centro custo orcado realizado por projeto")
    @PostMapping(path = "centros-custos-realizados-orcado-projetos/")
    public ResponseEntity<CentrosCustosOrcadoRealizadoProjetosRepresentation> salvarCentroCustoOrcadoRealizadoProjeto(
            @RequestHeader("Authorization") String token,
            @RequestBody CentrosCustosOrcadoRealizadoProjetosCommand comando) {
        CentrosCustosOrcadoRealizadoProjetos domain =
                serviceCentrosCustosOrcadoRealizadoProjetosService.salvar(comando);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CentrosCustosOrcadoRealizadoProjetosConverter.from(domain));
    }

    @ApiOperation(value = "Atualiza centro custo orcado realizado por projeto")
    @PutMapping(path = "centros-custos-realizados-orcado-projetos/")
    public ResponseEntity<CentrosCustosOrcadoRealizadoProjetosRepresentation> alterarCentroCustoOrcadoRealizadoProjeto(
            @RequestHeader("Authorization") String token,
            @RequestBody CentrosCustosOrcadoRealizadoProjetosCommand comando,
            @RequestParam(required = true, value = "codigoCooperativa") final Integer cooperativa,
            @RequestParam(required = true, value = "codigoPosto") final Integer posto) {
        CentrosCustosOrcadoRealizadoProjetos domain =
                serviceCentrosCustosOrcadoRealizadoProjetosService.atualizar(comando, cooperativa, posto);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(CentrosCustosOrcadoRealizadoProjetosConverter.from(domain));
    }

    @ApiOperation(value = "Exclui centro custo orcado realizado por projeto")
    @DeleteMapping(path = "centros-custos-realizados-orcado-projetos/")
    public ResponseEntity<CentrosCustosOrcadoRealizadoProjetosRepresentation> excluirCentroCustoOrcadoRealizadoProjeto(
            @RequestHeader("Authorization") String token,
            @RequestBody CentrosCustosOrcadoRealizadoProjetosCommand comando) {
        CentrosCustosOrcadoRealizadoProjetos domain = serviceCentrosCustosOrcadoRealizadoProjetosService.excluir(comando);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CentrosCustosOrcadoRealizadoProjetosConverter.from(domain));
    }
}

