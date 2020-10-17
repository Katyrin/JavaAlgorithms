package Exercise7;

//Задание 7.3

class Stack{
    private int maxSize;
    private int[] stackArr;
    private int top;
    public Stack(int size){
        this.maxSize = size;
        this.stackArr = new int[size];
        this.top = -1;
    }
    public void push(int i){
        stackArr[++top] = i;
    }
    public int pop(){
        return stackArr[top--];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public int peek(){
        return stackArr[top];
    }
}

class Vertex2{
    public char label;
    public boolean wasVisited;
    public Vertex2(char label){
        this.label = label;
        this.wasVisited = false;
    }
}

public class Graph2 {
    private final int MAX_VERTS = 32;
    private Vertex2[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;

    public Graph2(){
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex2[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++){
            for (int j = 0; j < MAX_VERTS; j++){
                adjMat[i][j] = 0;
            }
        }
    }

    private int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++){
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }

    // с нулевого значения
    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1){
                stack.pop();
            }else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++){
            vertexList[i].wasVisited = false;
        }
    }

    // со значения которое укажешь
    public void dfs(int f){
        vertexList[f].wasVisited = true;
        for (int i = 0; i < size; i++){
            int v = getAdjUnvisitedVertex(f);
            if (!vertexList[i].wasVisited && v != -1){
                fullDisplayVertex(f,v);
                dfs(i);
            }
        }
    }

    public void fullDisplayVertex(int vertex1, int vertex2){
        System.out.println("Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex2(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }
}
