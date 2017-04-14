import Pojo.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonConvert {
    public final static String workingDirectory = System.getProperty("user.dir");
    public final static String baseFile = "src\\main\\java\\Json\\src\\main\\resources\\user.json";
    public static void toJSON(User user) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile),user);
        System.out.println("Json created");
    }
    public static User toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile),User.class);
    }

    public static void main(String[] args) throws IOException {
        User user = new User(34,"John","8-956-334-44-33","12");
        JsonConvert.toJSON(user);
        System.out.println(JsonConvert.toJavaObject());
        ObjectMapper mapper = new ObjectMapper();
        User a = JsonConvert.toJavaObject();
        System.out.println(a.getId());

    }
}
