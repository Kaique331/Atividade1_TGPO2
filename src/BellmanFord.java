import java.util.Arrays;

public class BellmanFord {

    public BellmanFord(){}

    public void bellmanford(Graph grafo, int inicio){
        int inf = 999999999;
        int[] distancia = new int[grafo.getVertices()];
        Integer[] predecessor = new Integer[grafo.getVertices()];
        Arrays.fill(distancia, inf);
        Arrays.fill(predecessor, null);
        distancia[inicio] = 0;

        for (int i = 1; i < distancia.length-1; i++) {
            boolean mudou = false;
            for(Edge aresta: grafo.getEdges()){
                if(distancia[aresta.from] != inf & distancia[aresta.from] + aresta.weight < distancia[aresta.to]){
                    distancia[aresta.to] = distancia[aresta.from] + aresta.weight;
                    predecessor[aresta.to] = aresta.from;
                    mudou = true;
                }
            }
            if(!mudou){
                break;
            }
        }

        for (Edge aresta: grafo.getEdges()) {
            if(distancia[aresta.from] != inf & distancia[aresta.from] + aresta.weight < distancia[aresta.to]){
                System.out.println("ciclo negativo alcançável");
            }

        }
        
    }
}
