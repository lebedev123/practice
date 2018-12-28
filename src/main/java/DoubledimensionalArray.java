import java.util.Arrays;

/**
 * Двумерный массив является массивом массивов.
 * Имеется массив array[i,j] , где i это ссылка на элемент массива ,
 * при этом данный элемент тоже является ссылкой на массив ,
 * а j является как раз элементом массива
 * Например взять array[0][1] то - 0 является элементом массива
 * который ссылается на массив где нужно взять 1ый элемент
 *
 * array[i,j] , где i это номер строки, j - номер столбца
 */
public class DoubledimensionalArray {
    public static void main(String[] args) {
        int[] array = {3,8,2,7,9};
        Arrays.sort(array);
//        for(int i : array){
//            System.out.println(i);
//        }
        int [][] magicSquare = {
                {16,5,3},
                {1,2,4}
        };
        System.out.println(magicSquare[0][1]);
    }
}
