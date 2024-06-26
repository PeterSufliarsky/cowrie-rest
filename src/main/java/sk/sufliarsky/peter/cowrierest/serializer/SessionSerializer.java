package sk.sufliarsky.peter.cowrierest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sk.sufliarsky.peter.cowrierest.entity.Session;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SessionSerializer extends StdSerializer<Session> {

    public SessionSerializer() {
        this(null);
    }

    public SessionSerializer(Class<Session> t) {
        super(t);
    }

    @Override
    public void serialize(Session value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("id", value.getId());
        jgen.writeStringField("ip", value.getIp());

        if (value.getAsnId() != null) {
            jgen.writeNumberField("asnId", value.getAsnId());
        }

        if (value.getAsnName() != null) {
            jgen.writeStringField("asnName", value.getAsnName());
        }

        if (value.getCountry() != null) {
            jgen.writeStringField("country", value.getCountry());
        }

        if (value.getSensor() != null) {
            jgen.writeStringField("sensor", value.getSensor().getIp());
        }

        if (value.getStartTime() != null) {
            jgen.writeStringField("startTime", value.getStartTime().toString());
        }

        if (value.getEndTime() != null) {
            jgen.writeStringField("endTime", value.getEndTime().toString());
        }

        if (value.getClient() != null) {
            jgen.writeStringField("client", value.getClient().getVersion());
        }

        if (value.getTermSize() != null) {
            jgen.writeStringField("termSize", value.getTermSize());
        }

        jgen.writeEndObject();
    }
}
