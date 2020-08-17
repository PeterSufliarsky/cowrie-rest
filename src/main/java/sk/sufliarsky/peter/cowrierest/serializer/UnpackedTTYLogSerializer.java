package sk.sufliarsky.peter.cowrierest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sk.sufliarsky.peter.cowrierest.entity.UnpackedTTYLog;

import java.io.IOException;

public class UnpackedTTYLogSerializer extends StdSerializer<UnpackedTTYLog> {

    public UnpackedTTYLogSerializer() {
        this(null);
    }

    public UnpackedTTYLogSerializer(Class<UnpackedTTYLog> t) {
        super(t);
    }

    @Override
    public void serialize(UnpackedTTYLog value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("id", value.getSec() + "." + value.getUsec());
        jgen.writeStringField("hash", value.getHash());
        jgen.writeNumberField("op", value.getOp());
        jgen.writeNumberField("tty", value.getTty());
        jgen.writeNumberField("length", value.getLength());
        jgen.writeNumberField("dir", value.getDir());
        jgen.writeNumberField("sec", value.getSec());
        jgen.writeNumberField("usec", value.getUsec());
        jgen.writeStringField("data", value.getData());
        jgen.writeEndObject();
    }
}
