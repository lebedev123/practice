/**
 * Created by dos on 27.10.2016.
 */

import java.util.*;

public class NewTest {
    int Int = 34;

    public boolean equals(NewTest j){
        if(Int == j.Int )return true;
        else return false;
    }
    public static void main(String[] args) {
        NewTest test = new NewTest();
        NewTest test1 = new NewTest();
        System.out.println(test.equals(test1));
    }
}
