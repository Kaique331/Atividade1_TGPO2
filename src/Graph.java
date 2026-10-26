import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private final int vertices;
    private int[][] custos;
    private final List<Edge> edges = new ArrayList<>();
    Graph(int vertices) {
        this.vertices = vertices;
        this.custos = new int[vertices][vertices];
        for (int i = 0; i < vertices-1; i++) {
            for (int j = 0; j < vertices-1; j++) {
                custos[i][j] = 999999999;
            }
        }
    }
    void addEdge(int from, int to, int weight) {
        edges.add(new Edge(from, to, weight));
    }
    int getVertices() {
        return vertices;
    }
    List<Edge> getEdges() {
        return edges;
    }

    List<Edge> getAdjacentes(int vertice){
       List<Edge> adjacentes = new ArrayList<>();
       for(Edge ver: edges){
           if(ver.from == vertice){
               adjacentes.add(ver);
           }
       }
        return adjacentes;
    }

    public void completarTabelaCustos(){
        for(Edge aresta: edges){
            custos[aresta.from][aresta.to] = aresta.weight;
        }
    }

    public int[][] getCustos() {
        return custos;
    }
}
