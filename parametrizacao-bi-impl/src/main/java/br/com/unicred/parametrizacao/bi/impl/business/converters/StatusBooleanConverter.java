package br.com.unicred.parametrizacao.bi.impl.business.converters;

import javax.persistence.AttributeConverter;

public class StatusBooleanConverter implements AttributeConverter<Boolean, String> {
	
	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if (attribute) {
			return "S";
		} else {
			return "N";
		}
	}
	
	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		return (dbData.equals("S"));
	}
}
