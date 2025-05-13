package es.unican.ss.Practica6.seralizacion;


import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@SuppressWarnings("serial")
public class CustomLocalDateDeserializer extends StdDeserializer<LocalDate> {

	public CustomLocalDateDeserializer() {
		this(null);
	}

	public CustomLocalDateDeserializer(Class<?> t) {
		super(t);
	}

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String date = p.getText();
		return LocalDate.parse(date);
	}

}