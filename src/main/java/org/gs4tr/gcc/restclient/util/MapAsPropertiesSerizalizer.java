package org.gs4tr.gcc.restclient.util;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MapAsPropertiesSerizalizer extends JsonSerializer<Map<?, ?>> {

    @Override
    public void serialize(Map<?, ?> value, JsonGenerator generator,
                          SerializerProvider serializers) throws IOException,
            JsonProcessingException {

        generator.writeStartObject();
        
        for (Map.Entry<?, ?> entry : value.entrySet()){
            generator.writeObjectField(entry.getKey().toString(), entry.getValue());
        }
        generator.writeEndObject();
    }

}
