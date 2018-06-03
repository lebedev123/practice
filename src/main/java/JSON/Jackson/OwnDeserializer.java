package JSON.Jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class OwnDeserializer extends StdDeserializer {
    public OwnDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Car car = new Car();
        while (!jsonParser.isClosed()) {
            JsonToken jsonToken = jsonParser.nextToken();
            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = jsonParser.getCurrentName();
                System.out.println(fieldName);
                jsonToken = jsonParser.nextToken();
                if ("brand".equals(fieldName)) {
                    car.setBrand(jsonParser.getValueAsString());
                } else if ("doors".equals(fieldName)) {
                    car.setDoors(jsonParser.getValueAsInt());
                }
            }
        }
        return car;
    }
}
