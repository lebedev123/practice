package Algorithms;

public class SortsAndFinds {
    public static void main(String[] args) {
//        int[] randomArray = new int[]{1, 3, 2, 8, 4};
//    Алгоритмы соритровки
//        bubbleSort(randomArray);
//        insertSort(randomArray);
//        selectSort(randomArray);
//        mergeSort(randomArray);
//        fastSort(randomArray);
//        System.out.println("Result");
//        for (int i = 0; i < randomArray.length; i++) {
//            System.out.print(randomArray[i] + " ");
//        }
//   Алгоритмы поиска
//        int[] randomArray = new int[]{1, 2, 5, 6, 18};
//        int index = linearSearch(8,randomArray);
//        int index = binarySearch(18, randomArray);
//        System.out.println("Index " + index);
//  Специфические алгоритмы
//        Развернуть строку
//        String revereted = revertString("Java is shit");
//        System.out.println("Reverted string " + revereted);
//      Подсчет Фибоначи
//        int fibonachiNumber = 10;
//        int[] fibonachiArray = getFibonachi(fibonachiNumber);
//        for (int i : fibonachiArray) {
//            System.out.println(i);
//        }
//      Подсчет Факториала
//        int n = 5;
//        int factorial = factorial(n);
//        System.out.println(factorial);
    }

    /**
     * Сортировка пузырьком
     * Сортировка пузырьком работает проходя по массиву и сравнивая каждый элемент с последующим
     * Если последующий элемент меньше чем текущий то переставляет их местами
     * Итерации  производятся до тех пор пока при последнем проходе ни одна перестановка не выполнится и флаг не будет выставлен
     * Сложность по времени : Наилучший случай O(n) ; В среднем O(n^2) ; Наихудший случай O(n^2).
     * Сложность по памяти : Наилучший случай O(1) ; В среднем O(1) ; Наихудший случай O(1).
     *
     * @param randomArray
     */
    public static void bubbleSort(int[] randomArray) {
        boolean swapped;
        do {
            printArray(randomArray);
            swapped = false;
            for (int i = 0; i < randomArray.length - 1; i++) {
                if (randomArray[i] > randomArray[i + 1]) {
                    swap(randomArray, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);

    }

    /**
     * Сортировка выборкой
     * Сортировка выборкой работает по принципе выбрать наименьший элемент в неотсортированной части и поменять его местами
     * с текущей позицией в цикле for.
     * <p>
     * Сортировка выборкой отличается от сортировкой вставками тем что в сортировке выборкой мы запоминает границу отсортированной части и ищем в
     * не отсортированной наименьший элемент чтобы потом поменять местами с элементом границы.
     * В выборке вставкой мы берем следующий элементии вставляем его в нужную область в отсортированной части сразу
     * <p>
     * Сложность по времени : Наилучший случай O(n) ; В среднем O(n^2) ; Наихудший случай O(n^2).
     * Сложность по памяти : Наилучший случай O(1) ; В среднем O(1) ; Наихудший случай O(1).
     *
     * @param randomArray
     */
    public static void selectSort(int[] randomArray) {
        for (int i = 0; i < randomArray.length - 1; i++) {
            printArray(randomArray);
            int indexOfSmallest = findSmallestElement(randomArray, i);
            swap(randomArray, i, indexOfSmallest);
        }
    }

    /**
     * Сортировка вставками
     * Работает так же как сортировка пузырьком (проходим по массиву с начала и сравнивает два значения)
     * Но при сравнивании не меняет местами элементы,
     * а ищет подходящую позицию в массиве до текущей позиции(все элементы до текущей считаются отсортированными так как алгоритм по ним уже прошел).
     * <p>
     * Сортировка выборкой отличается от сортировкой вставками тем что в сортировке выборкой мы запоминает границу отсортированной части и ищем в
     * не отсортированной наименьший элемент чтобы потом поменять местами с элементом границы.
     * В выборке вставкой мы берем следующий элементии вставляем его в нужную область в отсортированной части сразу
     * <p>
     * Сложность по времени : Наилучший случай O(n) ; В среднем O(n^2) ; Наихудший случай O(n^2).
     * Сложность по памяти : Наилучший случай O(1) ; В среднем O(1) ; Наихудший случай O(1).
     *
     * @param randomArray
     */
    public static void insertSort(int[] randomArray) {
        for (int i = 0; i < randomArray.length - 1; i++) {
            printArray(randomArray);
            if (randomArray[i] > randomArray[i + 1]) {
                int sortValue = randomArray[i + 1];
                int valueIndex = i + 1;
                int positionToInsert = findPosition(randomArray, valueIndex, sortValue);
                System.out.println("position " + positionToInsert);
                insertElement(randomArray, positionToInsert, valueIndex);

            }
        }
    }

    /**
     * Меняет местами два элемента массива
     *
     * @param items
     * @param left
     * @param right
     */
    public static void swap(int[] items, int left, int right) {
        if (left != right) {
            int temp = items[left];
            items[left] = items[right];
            items[right] = temp;
        }
    }


    /**
     * Возвращает позицию элемента на котором должен находиться элемент
     *
     * @param randomArray
     * @param currentPosition
     * @param element
     * @return
     */
    public static int findPosition(int[] randomArray, int currentPosition, int element) {
        int position = 0;
        for (int i = 0; i < currentPosition; i++) {
            if (element < randomArray[i]) {
                position = i;
                break;
            }
        }
        return position;
    }


    /**
     * Сдвигает элементы массива и вставляет элемент на нужную позицию
     *
     * @param randomArray
     * @param from
     * @param to
     */
    public static void insertElement(int[] randomArray, int from, int to) {

        int element = randomArray[to];
        for (int i = to; i > from; i--) {
            randomArray[i] = randomArray[i - 1];
        }
        randomArray[from] = element;
    }


    private static void printArray(int[] randomArray) {
        for (int i = 0; i < randomArray.length; i++) {
            System.out.print(randomArray[i] + " ");
        }
        System.out.println();
    }

    /**
     * Находит индекс наименьшего элемента
     *
     * @param randomArray
     * @param startFrom
     * @return
     */
    public static int findSmallestElement(int[] randomArray, int startFrom) {
        int indexOfSmallest = startFrom;
        System.out.println("indexOfSmallest " + indexOfSmallest);
        for (int i = startFrom; i < randomArray.length; i++) {
            if (randomArray[indexOfSmallest] > randomArray[i]) {
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;
    }

    /**
     * Сортировка слиянием
     * Метод берет основной массив и делит его пополам, далее для каждой части (левой и правой)
     * формирует вызов этого же метода рекурсивно до тех пока длина левой и правой части для подмассивов не будет = 1
     * После этого оба единичных массива сливаются по принципу :
     * если достигнут конец массива левой части то добавить в выходной массив элемент от правой части
     * если достигнут конец массива правой части то добавить в выходной массив элемент от левой части
     * если элемент левого массива меньше правого то добавить в выходной массив элемент левый элемент
     * в ином случае добавить элемент правого массива.
     * Выход из цикла осуществляет только после перебора всех элементов левой и правой части.
     * После чего исходный массив рекурсивно сливается.
     * Сложность по времени : Наилучший случай O(n·log n) ; В среднем O(n·log n) ; Наихудший случай O(n·log n).
     * Сложность по памяти : Наилучший случай O(n) ; В среднем O(n) ; Наихудший случай O(n).
     * <p>
     * Пример:          [2100,40,23]
     * /             \
     * [2100]          [40,23]
     * \             /       \
     * \          [40]     [23]
     * \           \       /
     * \            merge
     * \          [23,40]
     * \         /
     * merge
     * [23,40,2100]
     *
     * @param randomArray
     */
    public static void mergeSort(int[] randomArray) {
        if (randomArray.length <= 1) {
            return;
        }

        int leftSize = randomArray.length / 2;
        int rightSize = randomArray.length - leftSize;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        System.arraycopy(randomArray, 0, left, 0, leftSize);
        System.arraycopy(randomArray, leftSize, right, 0, rightSize);
        mergeSort(left);
        mergeSort(right);
        Merge(randomArray, left, right);
    }


    private static void Merge(int[] items, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = 0;
        int remaining = left.length + right.length;
        while (remaining > 0) {
            if (leftIndex >= left.length) {
                items[targetIndex] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                items[targetIndex] = left[leftIndex++];
            } else if (left[leftIndex] < right[rightIndex]) {
                items[targetIndex] = left[leftIndex++];
            } else {
                items[targetIndex] = right[rightIndex++];
            }

            targetIndex++;
            remaining--;
        }
    }

    /**
     * Быстрая сортировка
     * Сначала выбирается случайный жлемент который будет ключевым . Далее все значения которые больше этого перемещаются вправо, а меньше влево.
     * Так осуществляется для каждого подмножества слева и справа.
     * Сначала центральное значение меняется местами с самым правым значением
     * Далее каждое значение меньшее чем 2 помещается меняется местами со значениями в начале массива
     * После этого центральное значение ( которое сейчас находится в конце) меняется со значением которое нахожится впереди тех значений которые были передвинуты в начало
     * <p>
     * Пример [13284] => выбирается 2, меняется со значением в конце => [13482] => все значения которые меньше 2 меняются со значениями в начале массива
     * Так как в данном случае меньше 2 только 1, то 1 остается на своем месте,
     * 2 меняется со значением которое стоит после всех значений меньших 2 (в ходе переноса всех значений в начало , позиция вставки цифры 2 запоминается)
     * Далее выбираются подмассивы слева и справа и для них выолняются такие же действия
     * <p>
     * Сложность по времени : Наилучший случай O(n·log n) ; В среднем O(n·log n) ; Наихудший случай O(n^2).
     * Сложность по памяти : Наилучший случай O(1) ; В среднем O(1) ; Наихудший случай O(1).
     */
    public static void fastSort(int[] randomArray) {
        quickSort(randomArray, 0, randomArray.length - 1);
    }

    private static void quickSort(int[] items, int left, int right) {
        printArray(items);
        if (left < right) {
            int centerIndex = (left + right) / 2;
            int newCenterIndex = partition(items, left, right, centerIndex);

            quickSort(items, left, newCenterIndex - 1);
            quickSort(items, newCenterIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right, int centerIndex) {
        int centerValue = arr[centerIndex];
        swap(arr, centerIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < centerValue) {
                swap(arr, i, storeIndex);
                storeIndex += 1;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    /**
     * Обычный алгоритм линейного (последовательного) поиска
     * <p>
     * Сложность по времени : Наилучший случай O(n) ; В среднем O(n) ; Наихудший случай O(n).
     * Сложность по памяти : Наилучший случай O(1) ; В среднем O(1) ; Наихудший случай O(1).
     *
     * @param valueToSearch
     * @param randomArray
     * @return
     */
    private static int linearSearch(int valueToSearch, int[] randomArray) {
        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] == valueToSearch) return i;
        }
        return -1;
    }

    /**
     * Бинарный поиск, используется только в отсортированном массиве
     * <p>
     * Сложность по времени : Наилучший случай O(log n) ; В среднем O(log n) ; Наихудший случай O(log n).
     * Сложность по памяти : Наилучший случай O(1) ; В среднем O(1) ; Наихудший случай O(1).
     *
     * @param valueToSearch
     * @param randomArray
     * @return
     */
    private static int binarySearch(int valueToSearch, int[] randomArray) {
        int left = 0;
        int right = randomArray.length - 1;
        while (left <= right) {
            int centerIndex = (right + left) / 2;
            if (randomArray[centerIndex] > valueToSearch) {
                right = centerIndex - 1;
            } else if (randomArray[centerIndex] < valueToSearch) {
                left = centerIndex + 1;
            } else {
                return centerIndex;
            }
        }
        return -1;
    }

    /**
     * Алгоритм разворота строки, просто ищем центральный индекс и меняем все элементы на расстоянии i от середины.
     *
     * @param s
     * @return
     */
    private static String revertString(String s) {
        char[] chars = s.toCharArray();
        int middle = chars.length / 2;
        for (int i = 0; i < middle; i++) {
            char leftElem = chars[i];
            char rightElem = chars[chars.length - 1 - i];
            chars[i] = rightElem;
            chars[chars.length - 1 - i] = leftElem;
        }
        return new String(chars);
    }

    /**
     * Простой алгоритм для последовательности Фибоначчи (Формула F_0 = 0,F_1 = 1, F_n = F_{n - 1} + F_{n - 2} )
     *
     * @param n
     * @return
     */
    private static int[] getFibonachi(int n) {
        int[] numbers = new int[n];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i < n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        return numbers;
    }

    /**
     * Алгоритм подсчета факториала числа ( алгоритм n!=1*2*3*...*n)
     *
     * @param n
     * @return
     */
    private static int factorial(int n) {
        int factorial;
        if (n == 1) {
            return n;
        } else {
            factorial = n * factorial(n - 1);
        }
        return factorial;

    }

}
