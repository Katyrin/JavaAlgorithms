package Exercise3;

// Задание 3.3

class MyLink<T>{
    private T link;
    private MyLink<T> next;

    public MyLink(T link){
        this.link = link;
    }
    public MyLink<T> getNext(){
        return next;
    }
    public void setNext(MyLink<T> next){
        this.next = next;
    }
    public T getValue(){
        return link;
    }

}

public class MyLinkedList<T> {
    private MyLink<T> first;

    public MyLinkedList(){
        first = null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void insert(T link){
        MyLink<T> l = new MyLink<>(link);
        l.setNext(first);
        this.first = l;
    }
    public MyLink<T> delete(){
        MyLink<T> temp = first;
        first = first.getNext();
        return temp;
    }
    public void display(){
        MyLink<T> current = first;
        while (current != null){
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
    }
    public T find(T searchNode){
        MyLink<T> findNode = new MyLink<>(searchNode);
        MyLink<T> current = first;
        while (current != null){
            if (current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
}
