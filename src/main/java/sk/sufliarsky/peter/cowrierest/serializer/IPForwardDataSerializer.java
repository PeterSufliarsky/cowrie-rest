package sk.sufliarsky.peter.cowrierest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sk.sufliarsky.peter.cowrierest.entity.IPForwardData;

import java.io.IOException;

public class IPForwardDataSerializer extends StdSerializer<IPForwardData> {

    public IPForwardDataSerializer() {
        this(null);
    }

    public IPForwardDataSerializer(Class<IPForwardData> t) {
        super(t);
    }

    @Override
    public void serialize(IPForwardData value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeStringField("timestamp", value.getTimestamp().toString());
        jgen.writeStringField("dstIp", value.getDstIp());
        jgen.writeNumberField("dstPort", value.getDstPort());
        jgen.writeStringField("data", value.getData());
        jgen.writeEndObject();
    }
}
