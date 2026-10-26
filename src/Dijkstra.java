import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    public Dijkstra(){}

    public void dijkstra(Graph grafo, int origem){
        int[] distancia = new int[grafo.getVertices()];
        Integer[] predecessor = new Integer[grafo.getVertices()];
        boolean[] visitado = new boolean[grafo.getVertices()];

        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(predecessor, null);
        Arrays.fill(visitado, false);
        distancia[origem] = 0;

        Comparator<EstadoFila> comparador = Comparator.comparingLong(e -> e.distancia);

        PriorityQueue<EstadoFila> fila = new PriorityQueue<>(comparador);

        fila.add(new EstadoFila(origem, 0));

        while(!fila.isEmpty()){
            EstadoFila atual = fila.poll();
            int vert = atual.vertice;

            if(visitado[vert] != true){
                visitado[vert] = true;
                for(Edge aya : grafo.getAdjacentes(vert)){
                    if(visitado[aya.to] == false){
                        int novadist = distancia[vert] + aya.weight;
                        if(novadist < distancia[aya.to]){
                            distancia[aya.to] = novadist;
                            predecessor[aya.to] = vert;

                            fila.add(new EstadoFila(aya.to, novadist));
                        }
                    }
                }
            }
        }

        System.out.println();
    }
}
