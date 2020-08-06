package sk.sufliarsky.peter.cowrierest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sk.sufliarsky.peter.cowrierest.entity.IPForward;

import java.io.IOException;

public class IPForwardSerializer extends StdSerializer<IPForward> {

    public IPForwardSerializer() {
        this(null);
    }

    public IPForwardSerializer(Class<IPForward> t) {
        super(t);
    }

    @Override
    public void serialize(IPForward value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("timestamp", value.getTimestamp().toString());
        jgen.writeStringField("dstIp", value.getDstIp());
        jgen.writeStringField("dstPort", Integer.toString(value.getDstPort()));
        jgen.writeEndObject();
    }
}
