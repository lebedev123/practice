package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dos on 07.02.2017.
 */
public class ReadChars {
    public static void main(String[] args) throws IOException{
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите символы; окончание ввода  - символ точки .");
        do {
            c = (char) br.read();
            System.out.println(c);
        }while (c !='.' );
    }
}
