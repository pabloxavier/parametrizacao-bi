package br.com.unicred.parametrizacao.bi.impl.business.converters;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Periodicidade;

public class PeriodicidadeConverter {

    public static String convertToStringDb(Periodicidade value) {

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

    public static Periodicidade convertToEnum(String value) {

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
