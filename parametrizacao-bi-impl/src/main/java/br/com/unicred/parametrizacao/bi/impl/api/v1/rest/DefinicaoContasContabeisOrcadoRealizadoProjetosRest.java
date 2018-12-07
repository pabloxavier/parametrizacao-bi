package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import br.com.unicred.parametrizacao.bi.api.v1.endpoints.DefaultEndpoint;
import br.com.unicred.parametrizacao.bi.api.v1.representation.DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ContasContabeisOrcadoRealizadoProjetos")
public class DefinicaoContasContabeisOrcadoRealizadoProjetosRest extends DefaultEndpoint {
   /* @Autowired
    private DefinicaoContasContabeisOrcadoRealizadoProjetosService service;

    @RequestMapping(value = "/IncluirContas", method = RequestMethod.GET)
    @ApiOperation(value = "Efetua a inclusão de novas Contas Contabeis.", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cooperativa", required = true, dataType = "integer", paramType = "header", value = "código da cooperativa") })
    @ApiResponses({ @ApiResponse(code = 200, message = "Requisição executada com sucesso."),
            @ApiResponse(code = 400, message = "Requisição com parâmetros invalidos."),
            @ApiResponse(code = 422, message = "Erro de negócio ou validação."),
            @ApiResponse(code = 500, message = "Erro não esperado.") })
    @CrossOrigin(allowedHeaders = "*")
    @GetMapping(value = "/ListarContasPorCooperativa")
    public ResponseEntity<?> findByCooperativa(@PathVariable("codigoCooperativa") final Integer cdCoop){
        List<DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation> conta = service.consultarPorCodigo(codigo);
        return ok(ContaRepresentation.from(conta));
    }*/

}
