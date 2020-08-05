package sk.sufliarsky.peter.cowrierest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sk.sufliarsky.peter.cowrierest.entity.Input;

import java.io.IOException;

public class InputSerializer extends StdSerializer<Input> {

    public InputSerializer() {
        this(null);
    }

    public InputSerializer(Class<Input> t) {
        super(t);
    }

    @Override
    public void serialize(Input value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("timestamp", value.getTimestamp().toString());
        jgen.writeStringField("realm", value.getRealm());
        jgen.writeStringField("success", value.getSuccess().toString());
        jgen.writeStringField("input", value.getInput());
        jgen.writeEndObject();
    }

}
