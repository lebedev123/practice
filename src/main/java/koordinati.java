/**
 * Created by dos on 22.07.2016.
 */
import  java.util.Scanner;
public class koordinati {
    public static void main(String[] args){
        int x1,y1,x2,y2;
        System.out.println("Vvedite kordinati");
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        int[]  s1 = new int[2];
        int [] s2 = new int [2];
        s1[0] = sc1.nextInt();
        s1[1]=sc2.nextInt();
        s2[0] = sc3.nextInt();
        s2[1] = sc4.nextInt();
        /*for(int i = 0;i<2 ; i++){
            System.out.println("koordinati" + s1[i]+" " + s2[i]);
            i++;
        }*/

        System.out.println("koordinati =" + s1[0]+" " + s1[1]);
        System.out.println("koordinati =" + s2[0]+" " + s2[1]);


    }
}
