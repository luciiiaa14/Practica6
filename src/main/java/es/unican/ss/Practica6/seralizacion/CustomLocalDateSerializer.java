package es.unican.ss.Practica6.seralizacion;


import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class CustomLocalDateSerializer extends StdSerializer<LocalDate> {

	public CustomLocalDateSerializer() {
		this(null);
	}

	public CustomLocalDateSerializer(Class<LocalDate> t) {
		super(t);
	}

	@Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {

		gen.writeString(value.toString());
	}

}