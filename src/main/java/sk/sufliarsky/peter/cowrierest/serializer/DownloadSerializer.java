package sk.sufliarsky.peter.cowrierest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sk.sufliarsky.peter.cowrierest.entity.Download;

import java.io.IOException;

public class DownloadSerializer extends StdSerializer<Download> {

    public DownloadSerializer() {
        this(null);
    }

    public DownloadSerializer(Class<Download> t) {
        super(t);
    }

    @Override
    public void serialize(Download value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("timestamp", value.getTimestamp().toString());
        jgen.writeStringField("url", value.getUrl());
        jgen.writeStringField("shasum", value.getShasum());
        jgen.writeEndObject();
    }
}
