package JSON.Jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class JsonTree {
    public static void main(String[] args) {
        String json =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "  \"nestedObject\" : { \"field\" : \"value\" } }";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readValue(json, JsonNode.class);
            JsonNode brandNode = node.get("brand");
            String brand = brandNode.asText();
            System.out.println("Brand is " + brand);
            JsonNode doors = node.get("doors");
            System.out.println("Number of doors is " + doors.asInt());
            JsonNode owners = node.get("owners");
            ArrayList<String> list = new ArrayList<>();
            if (owners.isArray()) {
                for (JsonNode obj : owners) {
                    list.add(obj.asText());
                }
            }
            StringBuilder sb = new StringBuilder();
            String delim = "";
            for (String i : list) {
                sb.append(delim).append(i);
                delim = ",";
            }
            System.out.println(sb);
            JsonNode parentObject = node.get("nestedObject");
            JsonNode child = parentObject.get("field");
            System.out.println("NestedObject value is " + child);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
