/**
 * Created by dos on 07.08.2016.
 */
public class hobbits {
    String name;
    public static void main(String[] args){
        hobbits[] h = new hobbits[3];
        int z = 0;
        while(z<3){
            h[z]=new hobbits();
            h[z].name="Bob";
            if(z == 1)  h[z].name= "Kevin";
            if(z == 2)  h[z].name = "Vitaly";
            System.out.println(h[z].name);
            z++;

        }
    }
}
