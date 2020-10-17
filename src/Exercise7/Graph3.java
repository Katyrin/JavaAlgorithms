package Exercise7;

//Задание 7.4

import java.util.LinkedList;
import java.util.Queue;

class Vertex3{
    public char label;
    public boolean wasVisited;
    public Vertex3(char label){
        this.label = label;
        this.wasVisited = false;
    }
}

public class Graph3 {
    private final int MAX_VERTS = 32;
    private Vertex3[] vertexList;
    private int[][] adjMat;
    private int size;

    public Graph3(){
        vertexList = new Vertex3[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++){
            for (int j = 0; j < MAX_VERTS; j++){
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex3(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    private int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++){
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }

    public void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;
        while (!queue.isEmpty()){
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i < size; i++){
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs(int v){
        int[] queue = new int[size];
        int qH = 0;
        int qT = 0;
        vertexList[0].wasVisited = true;
        queue[qT++] = v;
        displayVertex(0);
        int v2;
        while (qH < qT){
            v = queue[qH++];
            for (int i = 0; i < size; i++){
                v2 = getAdjUnvisitedVertex(v);
                if (!vertexList[i].wasVisited && v2 != -1){
                    vertexList[i].wasVisited = true;
                    displayVertex(qT);
                    queue[qT++] = i;
                }
            }
        }
        for (int i = 0; i < size; i++){
            vertexList[i].wasVisited = false;
        }
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }
}