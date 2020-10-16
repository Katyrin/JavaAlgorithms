package Exercise2;

import java.util.Arrays;
import java.util.Random;

public class Main2 {
    private int i;
    private static int primitiveInt = 11;
    private static byte primitiveByte = 2;
    private static long primitiveLong = 154;
    private static Integer referenceInteger = 5;
    private static Byte referenceByte = 3;
    private static Long referenceLong = 233L;
    private static int[] ints = {primitiveInt,primitiveByte,
            (int) primitiveLong,referenceInteger,referenceByte, Math.toIntExact(referenceLong)};

    private static long lastTime;
    private static long currentTime;
    private static float time;
    private static Random rand = new Random();

    Main2(int i){
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public static boolean isEqualsFive(int ...ints){
        lastTime = System.nanoTime();
        for (int i:ints){
            if (i == 5)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Main2 main = new Main2(7);

        System.out.println(main.getI());
        System.out.println(primitiveInt);
        System.out.println(referenceInteger);

        System.out.println(isEqualsFive(main.getI(),primitiveInt,referenceInteger));
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println(time);

        // 2 урок вызовы методов и сравнения
        arrayAccess(ints);
        linearSearch(ints,154);
        System.out.println("binarySearch(ints,154) = " + binarySearch(ints,154));
        int[] integers = new int[400];
        for (int i = 0;i < integers.length-1;i++)
            integers[i] = rand.nextInt(10000);
        System.out.println(Arrays.toString(integers));
        float ms = methodSort(integers);
        System.out.println(Arrays.toString(integers));
        float bs = bubbleSort(integers);
        System.out.println("methodSort(integers) " +
                (ms>bs?"медленнее":"быстрее") +
                " чем bubbleSort(integers)");
        System.out.println(ms<bs);
        System.out.println(Arrays.toString(integers));
        float ss = selectionSort(integers);
        System.out.println("selectionSort(integers) " +
                (ss>bs?"медленнее":"быстрее") +
                " чем bubbleSort(integers)");
        System.out.println("selectionSort(integers) " +
                (ss>ms?"медленнее":"быстрее") +
                " чем methodSort(integers)");
        System.out.println(Arrays.toString(integers));
        float is = insertSort(integers);
        System.out.println("insertSort(integers) " +
                (is>bs?"медленнее":"быстрее") +
                " чем bubbleSort(integers)");
        System.out.println("insertSort(integers) " +
                (is>ms?"медленнее":"быстрее") +
                " чем methodSort(integers)");
        System.out.println("insertSort(integers) " +
                (is>ss?"медленнее":"быстрее") +
                " чем selectionSort(integers)");

    }

    // Задание 2.1
    public static void arrayAccess(int[] ints){
        int[] newInts;
        lastTime = System.nanoTime();
        newInts = Arrays.copyOf(ints,ints.length);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("newInts = Arrays.copyOf(ints,ints.length) = "+time);

        lastTime = System.nanoTime();
        System.out.println(Arrays.toString(ints));
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("Arrays.toString(ints) = "+time);

        lastTime = System.nanoTime();
        Arrays.sort(ints);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println(Arrays.toString(ints));
        System.out.println("Arrays.sort(ints) = "+time);

        lastTime = System.nanoTime();
        System.out.println(Arrays.binarySearch(ints, 3));
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("Arrays.binarySearch(ints, 3) = "+time);

        lastTime = System.nanoTime();
        System.out.println(Arrays.equals(ints,newInts));
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("Arrays.equals(ints,newInts) = "+time);
    }

    //Задание 2.2
    public static boolean linearSearch(int[] ints, int a){
        lastTime = System.nanoTime();
        for (int i = 1;i < ints.length-1;i++){
            if (ints[i] == a){
                currentTime = System.nanoTime();
                time = (currentTime - lastTime) * 0.000000001f;
                System.out.println("linearSearch(int[] ints, int a) = "+time);
                return true;
            }
        }
        return false;
    }

    public static int binarySearch(int[] ints, int a){
        lastTime = System.nanoTime();
        int firstIndex = 0;
        int lastIndex = ints.length-1;
        while (firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex)/2;

            if (ints[middleIndex] == a){
                currentTime = System.nanoTime();
                time = (currentTime - lastTime) * 0.000000001f;
                System.out.println("binarySearch(int[] ints, int a) = "+time);
                return middleIndex;
            }else if (ints[middleIndex] < a){
                firstIndex = middleIndex + 1;
            }else if (ints[middleIndex] > a){
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    // Задание 2.3
    private static float methodSort(int[] ints){
        int[] integers = ints.clone();
        lastTime = System.nanoTime();
        Arrays.sort(integers);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println(Arrays.toString(integers));
        System.out.println("methodSort = "+time);
        return time;
    }

    // Задание 2.4
    public static float bubbleSort(int[] ints){
        int[] integers = ints.clone();
        int buff;
        boolean sorted;
        sorted = false;
        lastTime = System.nanoTime();
        while (!sorted){
            sorted = true;
            for (int i = 0;i < integers.length-1;i++){
                if (integers[i] > integers[i+1]){
                    sorted = false;
                    swap(integers,i,i+1);
                }
            }
        }
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println(Arrays.toString(integers));
        System.out.println("пузырчатая сортировка = "+time);
        return time;
    }

    private static void swap(int[] a,int first,int last){
        int buff = a[first];
        a[first] = a[last];
        a[last] = buff;
    }

    // Задание 2.5
    public static float selectionSort(int[] ints){
        int[] integers = ints.clone();
        lastTime = System.nanoTime();
        for (int i = 0;i < integers.length;i++){
            int min = i;
            for (int j = i+1;j < integers.length;j++){
                if (integers[j] < integers[min]){
                    min = j;
                }
            }
            swap(integers,i,min);
        }
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println(Arrays.toString(integers));
        System.out.println("сортировка выбора = "+time);
        return time;
    }

    // Задание 2.6
    public static float insertSort(int[] ints){
        int[] integers = ints.clone();
        int buff;
        int in;
        lastTime = System.nanoTime();
        for (int i = 1;i < integers.length;i++){
            buff = integers[i];
            in = i;
            while (in > 0 && integers[in-1] >= buff){
                integers[in] = integers[in-1];
                --in;
            }
            integers[in] = buff;
        }
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println(Arrays.toString(integers));
        System.out.println("сортировка вставки = "+time);
        return time;
    }
}