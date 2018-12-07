package br.com.unicred.parametrizacao.bi.impl.business.validators;

import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadRequestException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.MessageErrorDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public class CommandValidator<T> extends AbstractValidator {

    public void validate(T command) {

        List<MessageErrorDetail> violacoes =
                new ArrayList<MessageErrorDetail>();

        ValidatorFactory factoryValidator =
                Validation.buildDefaultValidatorFactory();

        Validator validator =
                factoryValidator.getValidator();

        Set<ConstraintViolation<T>>
                errosEncontrados =
                validator.validate(command);

        for (ConstraintViolation<T> error : errosEncontrados) {

            setRule(error);

            violacoes.add(
                    new MessageErrorDetail(
                            getFieldError(),
                            getMessageError()));
        }

        if (!violacoes.isEmpty()) {
            throw new BadRequestException(violacoes);
        }
    }
}
