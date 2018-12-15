package br.com.unicred.parametrizacao.bi.impl.business.validators;

import br.com.unicred.arch.validation.dto.FieldErrorMessage;
import br.com.unicred.arch.validation.exception.ValidationException;
import br.com.unicred.parametrizacao.bi.impl.business.commands.CentrosCustosOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.CentrosCustosOrcadoRealizadoProjetosDAO;
import io.jsonwebtoken.lang.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CentrosCustosOrcadoRealizadoProjetosValidator {

    private Logger log = LoggerFactory.getLogger(CentrosCustosOrcadoRealizadoProjetosValidator.class);

    public void validate(CentrosCustosOrcadoRealizadoProjetosCommand command){

        Assert.notNull(command, "O Objeto de Centros Custos Orcado Realizado Projetos não pode ser nulo");

        List<FieldErrorMessage> errors = new ArrayList<>();

        if(command.getCodigoCooperativa() == null) {
            errors.add(new FieldErrorMessage("codigoCooperativa", "O valor da cooperativa não pode ser nulo."));
        }
        if(command.getCodigoPosto() == null) {
            errors.add(new FieldErrorMessage("codigoPosto", "O valor do posto não pode ser nulo."));
        }
        if(command.getCodigoCooperativa() <= 0) {
            errors.add(new FieldErrorMessage("codigoCooperativa", "O valor da cooperativa não pode ser menor ou igual a zero."));
        }
        if(command.getCodigoPosto() < 0) {
            errors.add(new FieldErrorMessage("codigoPosto", "O valor do posto não pode ser menor do que zero."));
        }
        if (!errors.isEmpty()) {
            throw new ValidationException("Erro ao validar dados do objeto", errors);
        }
    }

    public void validate(Integer value){
        Assert.notNull(value, "O valor do campo não pode ser nulo");
    }

}
