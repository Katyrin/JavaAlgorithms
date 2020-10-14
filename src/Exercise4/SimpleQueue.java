package Exercise4;

import java.util.LinkedList;

public class SimpleQueue {
    private Person[] queue;
    private int maxSize;
    private int nElem;
    private int front;
    private int rear;

    public SimpleQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Person[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    public void insert(Person person) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = person;
        nElem++;
    }

    public void insertAll(LinkedList<Person> persons){
        for (Person p:persons){
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queue[++rear] = p;
            nElem++;
        }
    }

    public Person remove() {
        Person temp = queue[front++];

        if (front == maxSize) {
            front = 0;
        }
        nElem--;
        return temp;
    }

    public Person getFront() {
        return queue[front];
    }

    public Person getRear() {
        return queue[rear];
    }

    public boolean isFull() {
        return (nElem == maxSize - 1);
    }

    public boolean isEmpty() {
        return (nElem == 0);
    }

    public int getSize() {
        return nElem;
    }
}