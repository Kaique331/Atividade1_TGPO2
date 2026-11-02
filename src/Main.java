public class Main {
    public static void main(String[] args) {
        Graph cenario1 = new Graph(8, new String[]{"CD", "A", "B", "C", "D", "E", "F", "Cliente"});
        Graph cenario2 = new Graph(8, new String[]{"CD", "A", "B", "C", "D", "E", "F", "Cliente"});
        Graph cenarioTeste = new Graph(4, new String[]{"A", "B", "C", "D"});

        cenario1.addEdge(0, 1, 4);
        cenario1.addEdge(0, 2, 7);
        cenario1.addEdge(1, 2, 2);
        cenario1.addEdge(1, 3, 5);
        cenario1.addEdge(2, 3, 1);
        cenario1.addEdge(2, 4, 6);
        cenario1.addEdge(3, 4, 2);
        cenario1.addEdge(3, 5, 7);
        cenario1.addEdge(4, 5, 3);
        cenario1.addEdge(4, 6, 5);
        cenario1.addEdge(5, 6, 2);
        cenario1.addEdge(5, 7, 6);
        cenario1.addEdge(6, 7, 3);

        cenario1.addEdge(0, 1, 2);
        cenario1.addEdge(0, 2, 5);
        cenario1.addEdge(1, 3, 2);
        cenario1.addEdge(2, 1, -4);
        cenario1.addEdge(2, 4, 3);
        cenario1.addEdge(3, 4, 2);
        cenario1.addEdge(3, 5, 5);
        cenario1.addEdge(4, 5, 2);
        cenario1.addEdge(4, 7, 6);
        cenario1.addEdge(5, 6, 2);
        cenario1.addEdge(6, 7, 1);

        cenario1.addEdge(0, 1, 3);
        cenario1.addEdge(1, 2, 2);
        cenario1.addEdge(2, 0, -6);
        cenario1.addEdge(2, 3, 4);

        Dijkstra djin1 = new Dijkstra(cenario1) 
        Dijkstra djin2 = new Dijkstra(cenario2);

        BellmanFord bff1 = new BellmanFord(cenario1);
        BellmanFord bff2 = new BellmanFord(cenario2);
        BellmanFord bff3 = new BellmanFord(cenarioTeste);

        FloydWarshall fwa1 = new Floydwarshall(cenario1);
        FloydWarshall fwa2 = new Floydwarshall(cenario2);
        FloydWarshall fwa3 = new Floydwarshall(cenarioteste);

        System.out.println("cenario 1: ");
        djin1.dijkstra(0);
        bff1.bellmanford(0);
        fwa1.floydwarshall(0);

        System.out.println("cenario 2: ");
        djin2.dijkstra(0);
        bff2.bellmanford(0);
        fwa2.floydwarshall(0);

        System.out.println("cenario teste: ");
        bff3.bellmanford(0);
        fwa3.floydwarshall(0);
        
        
    }
}
