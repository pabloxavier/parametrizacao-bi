package br.com.unicred.parametrizacao.bi.impl.business.validators;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadRequestException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RegistroJaExistenteException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.PeriodoFechamentoRRDAO;

@Component
public class PeriodoFechamentoRRValidator {

   private PeriodoFechamentoRRDAO periodoFechamentoRRDAO;
   private Logger log = LoggerFactory.getLogger(PeriodoFechamentoRRValidator.class);

   public void validateInsert(PeriodoFechamentoRRCommand comando) {
       previneUnicidade(comando.getDataCompetenciaRankingRating());
   }

   public void validateDelete(PeriodoFechamentoRRCommand comando) {
       if (!existeRegistro(comando.getDataCompetenciaRankingRating())) {
           throw new NotFoundException("A data de competência informada " + comando.getDataCompetenciaRankingRating() + " não existe na base de dados.");
       }
   }

   public void previneUnicidade(LocalDate DataCompetenciaRankingRating) {
       if (existeRegistro(DataCompetenciaRankingRating)) {
           throw new RegistroJaExistenteException("Já existe a data de competência " + DataCompetenciaRankingRating + " na base de dados.");
       }
   }

   public Boolean existeRegistro(final LocalDate DataCompetenciaRankingRating) {
       try {
           periodoFechamentoRRDAO.buscaPeriodoFechamentoRRporData(DataCompetenciaRankingRating);
           return Boolean.TRUE;
       } catch (final EmptyResultDataAccessException e) {
           return Boolean.FALSE;
       } catch (final Exception e) {
           log.error("Existe registro para a data de competência " + DataCompetenciaRankingRating + ".", e);
           throw new BadRequestException(null);
       }
   }
}