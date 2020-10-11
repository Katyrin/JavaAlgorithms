package Exercise3;

import Exercise1.Main;

import java.util.*;
import java.util.stream.Collectors;

public class Main3 {

    private static Random rand = new Random();
    private static long lastTime;
    private static long currentTime;
    private static float time;

    public static void main(String[] args) {
        int[] integers = new int[400];
        for (int i = 0;i < integers.length-1;i++)
            integers[i] = rand.nextInt(10000);

        List<Integer> li = arrayIntoList(integers);
        System.out.println(li);
        System.out.println(arrayIntoCollection(integers));
        methodsInList(li);

        //Задание 3.3
        System.out.println(li);
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (Integer integer:li){
            myLinkedList.insert(integer);
        }
        myLinkedList.find(234);
        if (!myLinkedList.isEmpty())
            myLinkedList.display();


        LinkedList<Integer> linkedList = listIntoLinkedList(li);
        System.out.println(linkedList);
        System.out.println(myList());

        myIterator(linkedList);

    }
    // Задание 3.1
    private static List<Integer> arrayIntoList(int[] ints){
        lastTime = System.nanoTime();
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("arrayIntoList = "+time);

        return list;
    }

    private static Collection<Integer> arrayIntoCollection(int[] ints){
        lastTime = System.nanoTime();
        Collection<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("arrayIntoCollection = "+time);

        return list;
    }

    // Задание 3.2
    private static void methodsInList(List<Integer> list){
        lastTime = System.nanoTime();
        list.add(255);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("list.add(255) = "+time);

        lastTime = System.nanoTime();
        list.remove(255);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("list.remove(255) = "+time);

        lastTime = System.nanoTime();
        Integer i = list.get(7);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("list.get(7) = "+time);
        System.out.println(i);
    }

    // Задание 3.4
    private static LinkedList<Integer> listIntoLinkedList(List<Integer> list){
        LinkedList<Integer> ll = new LinkedList<>(list);
        ll.add(435);
        System.out.println(ll.peekLast());
        ll.removeLast();
        ll.addFirst(224);
        System.out.println(ll.peek());
        System.out.println(ll.poll());
        System.out.println(ll.get(34));
        System.out.println(ll.pollFirst());
        System.out.println(ll.pop());
        System.out.println(ll.contains(23));
        return ll;
    }

    private static LinkedList<Integer> myList(){
        Main main = new Main(3);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(main.getI());
        linkedList.add(Main.getPrimitive());
        linkedList.add(Main.getReference());
        return linkedList;
    }

    // Задание 3.5
    private static void myIterator(LinkedList<Integer> ll){
        Iterator<Integer> iterator = ll.iterator();
        lastTime = System.nanoTime();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("while (iterator.hasNext()) = "+time);
    }
}
