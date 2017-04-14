/**
 * Created by dos on 23.09.2016.
 */
public class StaticSuper {
    StaticSuper(){
        System.out.println("konstryktor");
    }
    static{
        System.out.println("Static");
    }}
 class StaticText extends StaticSuper{
        static  int rand;
        static{
            rand = (int)(Math.random()*6);
            System.out.println("Static blok do4erniu"+rand);
        }
     StaticText(){
         System.out.println("Do4erniu klass");
     }
     public static void main(String [] args){
         System.out.println("Into main");
         StaticText st = new StaticText();
     }}

