package sk.sufliarsky.peter.cowrierest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sk.sufliarsky.peter.cowrierest.entity.Auth;

import java.io.IOException;

public class AuthSerializer extends StdSerializer<Auth> {

    public AuthSerializer() {
        this(null);
    }

    public AuthSerializer(Class<Auth> t) {
        super(t);
    }

    @Override
    public void serialize(Auth value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("username", value.getUsername());
        jgen.writeStringField("password", value.getPassword());
        jgen.writeStringField("timestamp", value.getTimestamp().toString());
        jgen.writeStringField("success", value.getSuccess().toString());
        jgen.writeEndObject();
    }
}
