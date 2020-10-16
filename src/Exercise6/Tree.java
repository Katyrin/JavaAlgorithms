package Exercise6;

// Задание 6.2

class Person{
    public String name;
    public int id;
    public int age;
    public Person(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

class Node{
    public Person person;
    public Node leftChild;
    public Node rightChild;
    public void display(){
        System.out.println("ID: " + person.id + " Имя: " + person.name + " Возраст: " + person.age);
    }
}

public class Tree {
    private Node root;

    // Задание 6.3 метод вставки
    public void insert(Person person){
        Node node = new Node();
        node.person = person;
        if (root == null)
            root = node;
        else{
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (person.id < current.person.id){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    // Задание 6.3 метод поиска
    public Node find(int key){
        Node current = root;
        while (current.person.id != key){
            if (key < current.person.id){
                current = current.leftChild;
            }else {
                current = current.rightChild;
            }
            if (current == null)
                return  null;
        }
        return current;
    }

    // Задание 6.4 методы обхода дерева
    private void preOrder(Node rootNode){
        if (rootNode != null){
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }
    private void postOrder(Node rootNode){
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }
    private void inOrder(Node rootNode){
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    // Задание 6.4 методы максимума и минимума
    public Node min(){
        Node current,last = null;
        current = root;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }
    public Node max(){
        Node current,last = null;
        current = root;
        while (current != null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    // Задание 6.5 метод удаления
    public boolean delete(int id){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.person.id != id){
            parent = current;
            if (id < current.person.id){
                isLeftChild = true;
                current = current.leftChild;
            }else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null){
            if (current == root){
                root = null;
            }else if (isLeftChild){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
        }else if (current.rightChild == null){
            if (current == null){
                root = current.leftChild;
            }else if (isLeftChild){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
        }else if (current.leftChild == null){
            if (current == null){
                root = current.rightChild;
            }else if (isLeftChild){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
        }else {
            Node successor = getSuccessor(current);
            if (current == null){
                root = successor;
            }else if (isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    // Задание 6.4 метод дисплей
    public void displayTree(){
        Node current = root;
        System.out.println("Симметричный");
        inOrder(root);
        System.out.println("Прямой");
        preOrder(root);
        System.out.println("Обратный");
        postOrder(current);
    }
}
