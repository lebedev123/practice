package Operands;

import java.util.HashSet;
import java.util.Set;

public class Operands  {
    public static void main(String[] args) {
        int i =11;
        System.out.println(Integer.toBinaryString(i));
        i <<=10;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        i >>= 10;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(-1));
        int l = 3;
        l|= 1;
        System.out.println(l + " " + Integer.toBinaryString(l));
    }
}
