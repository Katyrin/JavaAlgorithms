package Exercise4;

import java.util.LinkedList;

public class SimpleStack {
    private int maxSize;
    private Person[] persons;
    private int top;

    public SimpleStack(int m) {
        this.maxSize = m;
        persons = new Person[maxSize];
        top = -1;
    }

    public void addElement(Person person) {
        persons[++top] = person;
    }

    public void addAll(LinkedList<Person> persons){
        for (Person p:persons){
            this.persons[++top] = p;
        }
    }

    public Person pollElement() {
        return persons[top--];
    }

    public Person readTop() {
        return persons[top];

    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public Integer getSize(){
        int count = 0;
        for (Person p:persons){
            if (p != null)
                count++;
        }
        return count;
    }
}