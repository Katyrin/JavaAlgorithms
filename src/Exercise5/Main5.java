package Exercise5;

//Задание 5.1
// два зеркала направиенные друг на друга

//Задание 5.3
//Стек вызова в жизни как пример выполнение человеком четко заданого распорядка дня по пунктам
// (Закончил одно переходишь к другому)
//Стек вызова с рекурсией как пример игра в шахматы с часами, сделал ход нажал на кнопку передал ход и так до конца игры

import java.util.Arrays;

public class Main5 {
    private static long lastTime;
    private static long currentTime;
    private static float time;
    private static int[] simpleRecursionArr = new int[10];
    private static int[] simpleCycleArr = new int[10];
    private static int count = 0;

    // массив из упр 2.1
    private static int primitiveInt = 11;
    private static byte primitiveByte = 2;
    private static long primitiveLong = 154;
    private static Integer referenceInteger = 5;
    private static Byte referenceByte = 3;
    private static Long referenceLong = 233L;
    private static int[] ints = {primitiveInt,primitiveByte,
            (int) primitiveLong,referenceInteger,referenceByte, Math.toIntExact(referenceLong)};
    private static int[] ints2 = Arrays.copyOf(ints,ints.length);

    public static void main(String[] args) {
        //recursionMethod(100);
        recursionMethodWithExit(10);

        // Задание 5.4
        lastTime = System.nanoTime();
        simpleRecursion(5);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("simpleRecursion(5) = "+time);
        System.out.println(Arrays.toString(simpleRecursionArr));

        lastTime = System.nanoTime();
        simpleCycle();
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("simpleCycle() = "+time);
        System.out.println(Arrays.toString(simpleCycleArr));

        // Задание 5.5
        Arrays.sort(ints);
        lastTime = System.nanoTime();
        System.out.println(binarySearchRecursively(ints,233,0,ints.length-1));
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("binarySearchRecursively() = "+time);

        lastTime = System.nanoTime();
        System.out.println(binarySearch(ints,233));
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("binarySearch() = "+time);

        //Задание 5.6
        lastTime = System.nanoTime();
        int[] ints3 = sortMerge(ints2);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("sortMerge() = "+time);
        System.out.println(Arrays.toString(ints3));

        lastTime = System.nanoTime();
        Arrays.sort(ints2);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("sort() = "+time);
        System.out.println(Arrays.toString(ints2));

    }

    // Задание 5.2

    private static int recursionMethod(int i){
        System.out.println(i++);
        return recursionMethod(i);
    }

    private static int recursionMethodWithExit(int i){
        System.out.println(i++);
        if (i >= 100)
            return i;
        return recursionMethodWithExit(i);
    }

    // Задание 5.4

    private static void simpleRecursion(int i){
        simpleRecursionArr[count++] = i++;
        if (count == 10)
            return;
        simpleRecursion(i);
    }

    private static void simpleCycle(){
        for (int i = 0;i < 10;i++){
            simpleCycleArr[i] = i + 5;
        }
    }

    // Задание 5.5

    private static int binarySearchRecursively(int[] arr,int key,int low,int high){
        int middle = (low+high)/2;
        if (high < low)
            return -1;
        if (key == arr[middle])
            return middle;
        else if (key < arr[middle])
            return binarySearchRecursively(arr,key,low,middle-1);
        else
            return binarySearchRecursively(arr,key,middle+1,high);
    }

    public static int binarySearch(int[] ints, int key){
        int firstIndex = 0;
        int lastIndex = ints.length-1;
        while (firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex)/2;
            if (ints[middleIndex] == key){
                return middleIndex;
            }else if (ints[middleIndex] < key){
                firstIndex = middleIndex + 1;
            }else if (ints[middleIndex] > key){
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    //Задание 5.6

    private static int[] sortMerge(int[] arr){
        int len = arr.length;
        if (len < 2)
            return arr;
        int middle = len/2;
        return merge(sortMerge(Arrays.copyOfRange(arr,0,middle)),sortMerge(Arrays.copyOfRange(arr,middle,len)));
    }

    private static int[] merge(int[] a,int[] b){
        int[] result = new int[a.length + b.length];
        int aIndex = 0, bIndex = 0;
        for (int i = 0;i < result.length;i++){
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length){
                System.arraycopy(b,bIndex,result,++i,b.length-bIndex);
                break;
            }
            if (bIndex == b.length){
                System.arraycopy(a,aIndex,result,++i,a.length-aIndex);
                break;
            }
        }
        return result;
    }
}
