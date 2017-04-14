/**
 * Created by dos on 10.08.2016.
 */
public class Clocl {
    String time ;
    void setTime(String time){
        this.time = time;
    }
    String getTime(){
        return time;
    }}
    class CloclPower {
        public  static  void main(String[] args){
            Clocl c = new Clocl();
            c.setTime("12345");
            String c1 = c.getTime();
            System.out.println(c1);
        }
    }

