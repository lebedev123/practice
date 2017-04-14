/**
 * Created by dos on 21.07.2016.
 */
public class n1 {
    public static void main(String[] args){
    String space = " ";
    String[] s1 = {"Новый","Старый"};
    String[] s2 = {"Утюг","Холодильник"};
    String[] s3 = {"Мой","Чужой"};
    int s11 = (int)(Math.random()*s1.length);
    int s12 = (int)(Math.random()*s2.length);
    int s13=(int)(Math.random()*s3.length);
    System.out.print(s3[s13]+ space+s1[s11] + space +s2[s12]);
}}
