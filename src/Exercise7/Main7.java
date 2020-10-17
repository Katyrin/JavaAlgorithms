package Exercise7;

//Задание 7.1
// графы используются в логистики в проложении наиболее выгодного маршрута маршрута

public class Main7 {
    private static long lastTime;
    private static long currentTime;
    private static long time;

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }

    //Задание 7.3
    private static void methodOne(){
        Graph2 graph2 = new Graph2();
        graph2.addVertex('A');
        graph2.addVertex('B');
        graph2.addVertex('C');
        graph2.addVertex('D');
        graph2.addVertex('E');
        graph2.addVertex('F');
        graph2.addVertex('G');

        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(3, 5);
        graph2.addEdge(4, 6);

        lastTime = System.nanoTime();
        graph2.dfs();
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("graph2.dfs() = "+time);

        lastTime = System.nanoTime();
        graph2.dfs(4);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("graph2.dfs(4) = "+time);
    }

    //Задание 7.4
    private static void methodTwo(){
        Graph3 graph3 = new Graph3();
        graph3.addVertex('A');
        graph3.addVertex('B');
        graph3.addVertex('C');
        graph3.addVertex('D');
        graph3.addVertex('E');
        graph3.addVertex('F');
        graph3.addVertex('G');

        graph3.addEdge(0, 1);
        graph3.addEdge(0, 2);
        graph3.addEdge(0, 3);
        graph3.addEdge(1, 4);
        graph3.addEdge(3, 5);
        graph3.addEdge(4, 6);

        lastTime = System.nanoTime();
        graph3.bfs();
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("graph2.bfs() = "+time);

        lastTime = System.nanoTime();
        graph3.bfs(4);
        currentTime = System.nanoTime();
        time = (currentTime - lastTime);
        System.out.println("graph2.bfs(4) = "+time);
    }
}
