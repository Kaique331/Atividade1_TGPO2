import java.util.Arrays;

public class BellmanFord {
    public final int inf = 999999999;
    int[] distancia;
    Integer[] predecessor;
    Graph grafo;

    public BellmanFord(Graph grafo){
        this.grafo = grafo;
        this.distancia = new int[grafo.getVertices()];
        this.predecessor = new Integer[grafo.getVertices()];
        Arrays.fill(distancia, inf);
        Arrays.fill(predecessor, null);}

    public void bellmanford(Graph grafo, int inicio){

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

        int total = 0, pos = predecessor.length-1;
        while(predecessor[pos] != null){
            total += distancia[pos];
            pos = predecessor[pos];
        }

        System.out.println("inicio: " + grafo.descricao_vertice(inicio));
        System.out.println("destino: " + grafo.descricao_vertice(grafo.getVertices-1));
        System.out.println("Total do caminho: " + total);
        reconstruir_caminho();

    }

    public void reconstruir_caminho(){
        System.out.println("caminho do grafo: ");

        for (int i = 0; i < predecessor.length-1; i++) {
            System.out.print(grafo.descricao_vertice(predecessor[i]) + " -> ");
        }
        System.out.println(";");

    }
}
