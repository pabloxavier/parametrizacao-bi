package br.com.unicred.parametrizacao.bi.impl.business.converters;

public class BooleanConverter {
	
	public static String booleanToLetra(Boolean bool) {
		return bool ? "S" : "N";
	}
	
	public static Boolean letraToBoolean(String string) {
		return string.equals("S");
	}
	
    public static String booleanToPalavra(Boolean bool) {
        return bool ? "Sim" : "Não";
    }
    
    public static String letraToPalavra(String letra) {
        return letra.equals("S") ? "Sim" : "Não";
    }    
}
