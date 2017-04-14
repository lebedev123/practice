import java.util.Scanner;

import java.util.Arrays;
/**
 * Created by dos on 13.11.2016.
 */
public class VimpiresNumberTest {
    void genDig(){
        for(int i = 10; i<100; i++){
            for(int j = 10; j<100; j++){
                int s = i*j;

                //число s преобразовываем в строку, затем записываем в массив символов
                char b[] = (new Integer(s)).toString().toCharArray();
                Arrays.sort(b); //сортировка массива символов

                //так само поступаем с каждым множителем
                String x = (new Integer(i).toString());
                String y = (new Integer(j).toString());
                //конкатенация строк (чисел-множителей)
                String z = x + y;
                //запись строки в массив символов
                char p[] = z.toCharArray();
                Arrays.sort(p); //сортировка массива символов

                //сравнение массивов символов
                if(Arrays.equals(b, p)) {
                    System.out.println(i+" * "+j+" = "+s);
                }

            }
        }
    }

    public static void main(String[] args) {
        VimpiresNumberTest vn = new VimpiresNumberTest();
        vn.genDig();

    }
}
