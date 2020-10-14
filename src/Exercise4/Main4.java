package Exercise4;

import java.util.*;

public class Main4 {
    private static LinkedList<Person> personLinkedList;
    private static long lastTime;
    private static long currentTime;
    private static float time;

    private static Person person = new Person("newPerson",7834653429L,"7834653429@mail.ru");

    private static void initPLL(){
        personLinkedList = new LinkedList<>();
        personLinkedList.add(new Person("Roman",89997776655L,"89997776655@mail.ru"));
        personLinkedList.add(new Person("Artem",81117776655L,"81117776655@mail.ru"));
        personLinkedList.add(new Person("Anton",81117776644L,"81117776644@mail.ru"));
        personLinkedList.add(new Person("Igor",81117774355L,"81117774355@mail.ru"));
        personLinkedList.add(new Person("Dima",81112226655L,"81117776655@mail.ru"));
    }

    public static void main(String[] args) {
        initPLL();
        SimpleStack ss = personStack(personLinkedList);
        SimpleQueue sq = personQueue(personLinkedList);
        personDeque(personLinkedList);
        priorityQueueMethod();
        stackLinkedList(ss);
        queueLinkedList(sq);
    }

    // Задание 4.1

    private static SimpleStack personStack(LinkedList<Person> llPerson){
        SimpleStack simpleStack = new SimpleStack(10);

        lastTime = System.nanoTime();
        simpleStack.addAll(llPerson);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleStack.addAll(llPerson) = "+time);

        lastTime = System.nanoTime();
        simpleStack.addElement(person);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleStack.addElement(person) = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleStack.isEmpty());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleStack.isEmpty() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleStack.isFull());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleStack.isFull() = "+time);

        lastTime = System.nanoTime();
        simpleStack.pollElement();
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleStack.pollElement() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleStack.readTop());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleStack.readTop() = "+time);

        return simpleStack;
    }

    // Задание 4.2

    private static SimpleQueue personQueue(LinkedList<Person> llPerson){
        SimpleQueue simpleQueue = new SimpleQueue(10);

        lastTime = System.nanoTime();
        simpleQueue.insertAll(llPerson);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleQueue.insertAll(llPerson) = "+time);

        lastTime = System.nanoTime();
        simpleQueue.insert(person);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleQueue.insert(person) = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleQueue.getFront());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleQueue.getFront() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleQueue.getRear());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleQueue.getRear() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleQueue.getSize());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleQueue.getSize() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleQueue.isEmpty());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleQueue.isEmpty() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleQueue.isFull());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleQueue.isFull() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleQueue.remove());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleQueue.remove() = "+time);

        return simpleQueue;
    }

    // Задание 4.3

    private static void personDeque(LinkedList<Person> llPerson){
       SimpleDeque simpleDeque = new SimpleDeque(10);

        lastTime = System.nanoTime();
        simpleDeque.putAll(llPerson);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleDeque.putAll(llPerson) = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleDeque.getSize());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleDeque.getSize() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleDeque.isEmpty());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleDeque.isEmpty() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleDeque.isFull());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleDeque.isFull() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleDeque.pollBack());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleDeque.pollBack() = "+time);

        lastTime = System.nanoTime();
        System.out.println(simpleDeque.pollFront());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleDeque.pollFront() = "+time);

        lastTime = System.nanoTime();
        simpleDeque.putBack(person);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleDeque.putBack(person) = "+time);

        lastTime = System.nanoTime();
        simpleDeque.putFront(person);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("simpleDeque.putFront(person) = "+time);
    }

    // Задание 4.4

    private static void priorityQueueMethod(){
        PriorityQueue priorityQueue = new PriorityQueue(10);
        int[] ints = {22,15,23,77,2,44,35,66,78,99};

        for (int i:ints){
            lastTime = System.nanoTime();
            priorityQueue.addElement(i);
            currentTime = System.nanoTime();
            time = (currentTime - lastTime) * 0.000000001f;
            System.out.println("priorityQueue.addElement(i) = "+time);
        }

        lastTime = System.nanoTime();
        System.out.println(priorityQueue.isEmpty());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("priorityQueue.isEmpty() = "+time);

        lastTime = System.nanoTime();
        System.out.println(priorityQueue.isFull());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("priorityQueue.isFull() = "+time);

        lastTime = System.nanoTime();
        System.out.println(priorityQueue.pollElement());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("priorityQueue.pollElement() = "+time);

        lastTime = System.nanoTime();
        System.out.println(priorityQueue.readTop());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("priorityQueue.readTop() = "+time);
    }

    // Задание 4.5

    private static void stackLinkedList(SimpleStack simpleStack){
        StackLinkedList<Person> stackLinkedList = new StackLinkedList<>();
        for (int i = 0;i < simpleStack.getSize()-1;i++){
            Person p = simpleStack.pollElement();
            lastTime = System.nanoTime();
            stackLinkedList.push(p);
            currentTime = System.nanoTime();
            time = (currentTime - lastTime) * 0.000000001f;
            System.out.println("stackLinkedList.push(p) = "+time);
            System.out.println(p);
        }

        lastTime = System.nanoTime();
        System.out.println(stackLinkedList.isEmpty());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("stackLinkedList.isEmpty() = "+time);

        lastTime = System.nanoTime();
        System.out.println(stackLinkedList.pop());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("stackLinkedList.pop() = "+time);

    }

    private static void queueLinkedList(SimpleQueue simpleQueue){
        QueueLinkedList<Person> queueLinkedList = new QueueLinkedList<>();
        for (int i = 0; i < simpleQueue.getSize();i++){
            Person p = simpleQueue.remove();
            lastTime = System.nanoTime();
            queueLinkedList.insert(p);
            currentTime = System.nanoTime();
            time = (currentTime - lastTime) * 0.000000001f;
            System.out.println("queueLinkedList.insert(p) = "+time);
            System.out.println(p);
        }

        lastTime = System.nanoTime();
        System.out.println(queueLinkedList.delete());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("queueLinkedList.delete() = "+time);

        lastTime = System.nanoTime();
        System.out.println(queueLinkedList.isEmpty());
        currentTime = System.nanoTime();
        time = (currentTime - lastTime) * 0.000000001f;
        System.out.println("queueLinkedList.isEmpty() = "+time);
    }
}
