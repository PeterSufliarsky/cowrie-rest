package sk.sufliarsky.peter.cowrierest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sk.sufliarsky.peter.cowrierest.entity.TTYLog;

import java.io.IOException;

public class TTYLogSerializer extends StdSerializer<TTYLog> {

    public TTYLogSerializer() {
        this(null);
    }

    public TTYLogSerializer(Class<TTYLog> t) {
        super(t);
    }

    @Override
    public void serialize(TTYLog value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeStringField("ttylog", value.getTtylog().substring(value.getTtylog().lastIndexOf('/') + 1));
        jgen.writeNumberField("size", value.getSize());
        jgen.writeEndObject();
    }
}
