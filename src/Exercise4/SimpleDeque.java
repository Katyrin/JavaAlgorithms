package Exercise4;

import java.util.LinkedList;

public class SimpleDeque {
    private Person[] queue;
    private int maxSize;
    private int nElem;
    private int front;
    private int rear;

    public SimpleDeque(int maxSize) {
        this.maxSize = maxSize;
        queue = new Person[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    public void putAll(LinkedList<Person> persons){
        for (Person p:persons){
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queue[++rear] = p;
            nElem++;
        }
    }

    public void putBack(Person person) {
        if (rear == maxSize - 1) {
            rear = -1;
        }

        queue[++rear] = person;
        nElem++;
    }

    public void putFront(Person person) {
        if (front == 0) {
            front = maxSize - 1;
        }

        queue[--front] = person;
        nElem++;
    }

    public Person pollFront() {
        Person temp = queue[front];
        front++;
        if (front == maxSize) {
            front = 0;
        }
        nElem--;
        return temp;
    }

    public Person pollBack() {
        Person temp = queue[rear--];

        if (rear == -1) {
            rear = maxSize;
        }
        nElem--;
        return temp;
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