package br.com.unicred.parametrizacao.bi.impl.business.converters;

import javax.persistence.AttributeConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Periodicidade;


public class PeriodicidadeConverter implements AttributeConverter<Periodicidade, String> {

	@Override
	public String convertToDatabaseColumn(Periodicidade value) {
	
		switch (value) {
        case ANUAL:
            return "A";
        case DIARIO:
            return "D";
        case MENSAL:
            return "M";
    }
		return null;
	}

	@Override
	public Periodicidade convertToEntityAttribute(String value) {

		switch (value) {
		case "A":
			return Periodicidade.ANUAL;
		case "D":
			return Periodicidade.DIARIO;
		case "M":
			return Periodicidade.MENSAL;
		}
		return null;
	}
}
