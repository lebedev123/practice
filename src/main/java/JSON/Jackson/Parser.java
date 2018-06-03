package JSON.Jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class Parser {
    public static void main(String[] args) throws IOException {
        String jsonDog = "{\"name\" : \"Josya\", \"age\" : \"55\", " +
                "\"child\" : [\"bob\", \"lucy\"]}";
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(jsonDog);
        while (!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();
            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = parser.getCurrentName();
                System.out.print(fieldName);
                jsonToken = parser.nextToken();
                if (fieldName.equals("age = ")) {
                    Integer age = parser.getValueAsInt();
                    System.out.println(age);
                } else if (JsonToken.START_ARRAY.equals(jsonToken)){
                    System.out.print(" is ");
                    jsonToken = parser.nextToken();
                    while(!JsonToken.END_ARRAY.equals(jsonToken)){
                        System.out.print(parser.getValueAsString() + " ");
                        jsonToken = parser.nextToken();
                    }
                }else {
                    System.out.println(" = " + parser.getValueAsString());
                }
            }
        }
    }
}
