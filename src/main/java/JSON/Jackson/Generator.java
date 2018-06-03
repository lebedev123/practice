package JSON.Jackson;

import com.fasterxml.jackson.core.JsonFactory;

public class Generator {
    public static void main(String[] args) {
        JsonFactory factory = new JsonFactory();
        Car car = new Car("Mercedes",5);
        //??
    }
}
