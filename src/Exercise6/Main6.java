package Exercise6;

// Задание 6.1
// пример из жизни: родословная

//Задание 6.7
// пример из жизни: турнирная таблица по завершению всех встреч

import Exercise2.Main2;

import java.util.Arrays;

public class Main6 {
    private static long lastTime;
    private static long currentTime;
    private static float time;

    // массив из упр 2.1
    private static int primitiveInt = 11;
    private static byte primitiveByte = 2;
    private static long primitiveLong = 154;
    private static Integer referenceInteger = 5;
    private static Byte referenceByte = 3;
    private static Long referenceLong = 233L;
    private static int[] ints = {primitiveInt,primitiveByte,
            (int) primitiveLong,referenceInteger,referenceByte, Math.toIntExact(referenceLong),24,11};

    public static void main(String[] args) {
        treeMethod();

        heapMethod();
    }

    // Задание 6.5 оценка времени выполнения базовых методов
    private static void treeMethod(){
        Tree theTree = new Tree();
        theTree.insert(new Person(7,"Roman1",29));
        theTree.insert(new Person(2,"Roman2",15));
        theTree.insert(new Person(4,"Roman3",22));
        theTree.insert(new Person(9,"Roman4",33));
        theTree.insert(new Person(35,"Roman5",45));
        theTree.insert(new Person(3,"Roman6",25));
        theTree.insert(new Person(15,"Roman7",24));
        lastTime = System.nanoTime();
        theTree.insert(new Person(12,"Roman8",28));
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("метод вставки = "+time);

        lastTime = System.nanoTime();
        theTree.max().display();
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("метод поиска максимального узла = "+time);

        lastTime = System.nanoTime();
        theTree.min().display();
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("метод поиска минимального узла = "+time);

        lastTime = System.nanoTime();
        theTree.find(9).display();
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("метод поиска узла = "+time);

        lastTime = System.nanoTime();
        theTree.delete(2);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("метод удаления узла = "+time);

        System.out.println();

        lastTime = System.nanoTime();
        theTree.displayTree();
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("метод отображения = "+time);
    }

    // Задание 6.6
    private static void heapMethod(){
        int[] copy1 = Arrays.copyOf(ints,ints.length);
        int[] copy2 = Arrays.copyOf(ints,ints.length);
        int[] copy3 = Arrays.copyOf(ints,ints.length);
        int[] copy4 = Arrays.copyOf(ints,ints.length);
        System.out.println(Arrays.toString(copy1));

        lastTime = System.nanoTime();
        HeapSort.sort(copy1);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("Пирамидальная сортировка = "+time);

        System.out.println(Arrays.toString(copy1));

        // ниже сравнение с другими сортировками
        lastTime = System.nanoTime();
        Arrays.sort(ints);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("Стандартный метод сортировки = "+time);

        Main2.bubbleSort(copy2);
        Main2.insertSort(copy3);
        Main2.selectionSort(copy4);
    }
}
