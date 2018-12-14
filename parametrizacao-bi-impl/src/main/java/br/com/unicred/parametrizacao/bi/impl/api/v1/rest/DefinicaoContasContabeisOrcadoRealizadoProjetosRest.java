package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import br.com.unicred.parametrizacao.bi.api.v1.endpoints.DefaultEndpoint;
import br.com.unicred.parametrizacao.bi.api.v1.representation.DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoContasContabeisOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.services.DefinicaoContasContabeisOrcadoRealizadoProjetosService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parametrizacao/bi/v1/ContasContabeisOrcadoRealizadoProjetos")
public class DefinicaoContasContabeisOrcadoRealizadoProjetosRest extends DefaultEndpoint {
    @Autowired
    private DefinicaoContasContabeisOrcadoRealizadoProjetosService service;


    @ApiOperation(value = "Efetua a listagem de Contas Contabeis por Cooperativa.", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cooperativa", required = true, dataType = "integer", paramType = "header", value = "código da cooperativa") })
    @ApiResponses({ @ApiResponse(code = 200, message = "Requisição executada com sucesso."),
            @ApiResponse(code = 400, message = "Requisição com parâmetros invalidos."),
            @ApiResponse(code = 422, message = "Erro de negócio ou validação."),
            @ApiResponse(code = 500, message = "Erro não esperado.") })
    @CrossOrigin(allowedHeaders = "*")
    @RequestMapping(value = "/ListarContasPorCooperativa", method = RequestMethod.GET)
    public ResponseEntity<?> findByCooperativa(@RequestHeader("Authorization") final String token,
                                               @PathVariable("codigoCooperativa") final Integer cdCoop) {
        List<DefinicaoContasContabeisOrcadoRealizadoProjetos> conta = service.listarPorCooperativa(cdCoop);
        return ok();
    }

    @ApiOperation(value = "Efetua a criação de Contas Contabeis .", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cooperativa", required = true, dataType = "integer", paramType = "header", value = "código da cooperativa") })
    @ApiResponses({ @ApiResponse(code = 200, message = "Requisição executada com sucesso."),
            @ApiResponse(code = 400, message = "Requisição com parâmetros invalidos."),
            @ApiResponse(code = 422, message = "Erro de negócio ou validação."),
            @ApiResponse(code = 500, message = "Erro não esperado.") })
    @CrossOrigin(allowedHeaders = "*")
    @RequestMapping(value = "/criarContas", method = RequestMethod.POST)
    public ResponseEntity<?> findByCooperativa(@RequestHeader("Authorization") final String token,
                                               @RequestBody DefinicaoContasContabeisOrcadoRealizadoProjetosCommand comando) {
        DefinicaoContasContabeisOrcadoRealizadoProjetos conta = service.salvarContaContabil(comando);
        return ok();
    }



}