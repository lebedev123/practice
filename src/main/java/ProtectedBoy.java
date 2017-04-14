/**
 * Created by dos on 31.12.2016.
 */
public class ProtectedBoy {
    protected  String last_name;//naslednik
    private  int card_id;//class
    public String first_name;//all code
    int age;//package
}
class SubClassProtectedBoy extends  ProtectedBoy{
    public static void main(String... args){
        ProtectedBoy boy = new ProtectedBoy();
        System.out.println(boy.age + boy.first_name + boy.last_name);
    }
}
