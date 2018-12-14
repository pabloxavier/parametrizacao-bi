package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.endpoints.DefaultEndpoint;
import br.com.unicred.parametrizacao.bi.api.v1.representation.DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.converters.DefinicaoContasContabeisOrcadoRealizadoProjetosConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoContasContabeisOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.services.DefinicaoContasContabeisOrcadoRealizadoProjetosService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(allowedHeaders = "*")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Contas Contabeis Orcado Realizado Projetos API")
@RestController
@RequestMapping("/parametrizacao/bi/v1/ContasContabeisOrcadoRealizadoProjetos")
public class DefinicaoContasContabeisOrcadoRealizadoProjetosRest extends DefaultEndpoint {
    @Autowired
    private DefinicaoContasContabeisOrcadoRealizadoProjetosService service;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(@RequestHeader("Authorization") final String token) {
        List<DefinicaoContasContabeisOrcadoRealizadoProjetos> contas = service.listarContasAtivas();
        return ok(DefinicaoContasContabeisOrcadoRealizadoProjetosConverter.from(contas));
    }

    @RequestMapping(value = "/ListarContasPorCooperativa", method = RequestMethod.GET)
    public ResponseEntity<?> findByCooperativa(@RequestHeader("Authorization") final String token,
                                               @PathVariable("codigoCooperativa") final Integer cdCoop) {
        List<DefinicaoContasContabeisOrcadoRealizadoProjetos> conta = service.listarPorCooperativa(cdCoop);
        return ok();
    }

    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<?> findByCooperativa(@RequestHeader("Authorization") final String token,
                                               @RequestBody DefinicaoContasContabeisOrcadoRealizadoProjetosCommand comando) {
        DefinicaoContasContabeisOrcadoRealizadoProjetos conta = service.salvarContaContabil(comando);
        return ok(DefinicaoContasContabeisOrcadoRealizadoProjetosConverter.from(conta));
    }



}