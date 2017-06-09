package MVC.MyMVC;

public class Main {
    public static void main(String[] args) {
        View view = new View(new Controller(new Model()));
    }
}
