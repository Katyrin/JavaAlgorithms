package Exercise4;


class MyLink2<T>{
    private T link;
    public MyLink2<T> next;

    public MyLink2(T link){
        this.link = link;
    }
    public MyLink2<T> getNext(){
        return next;
    }
    public void setNext(MyLink2<T> next){
        this.next = next;
    }
    public T getValue(){
        return link;
    }

}

class MyLinkedList2<T> {
    private MyLink2<T> first;
    private MyLink2<T> last;

    public MyLinkedList2(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void insert(T link){
        MyLink2<T> newLink = new MyLink2<>(link);
        if (this.isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }
    public MyLink2<T> delete(){
        MyLink2<T> temp = first;
        if (first.next == null)
            last = null;
        else
            first = first.getNext();
        return temp;
    }
    public void display(){
        MyLink2<T> current = first;
        while (current != null){
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
    }
    public T find(T searchNode){
        MyLink2<T> findNode = new MyLink2<>(searchNode);
        MyLink2<T> current = first;
        while (current != null){
            if (current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
}

public class QueueLinkedList<T> {
    private MyLinkedList<T> queue;
    public QueueLinkedList(){
        queue = new MyLinkedList<>();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public void insert(T link){
        queue.insert(link);
    }
    public String delete(){
        return queue.delete().getValue().toString();
    }
}
