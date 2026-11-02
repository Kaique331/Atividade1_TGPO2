import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    int[] distancia;
    Integer[] predecessor;
    boolean[] visitado;
    Graph grafo;

    public Dijkstra(Graph grafo){
        distancia = new int[grafo.getVertices()];
        predecessor = new Integer[grafo.getVertices()];
        visitado = new boolean[grafo.getVertices()];
        this.grafo = grafo;

        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(predecessor, null);
        Arrays.fill(visitado, false);
    }

    public void dijkstra(int origem){
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

        System.out.println("origem: " + grafo.descricao_vertice(origem));
        System.out.println("destino: " + grafo.descricao_vertice(grafo.getVertices()-1);
        System.out.println("custo total do caminho: " + distancia[distancia.length-1] + ";");
        reconstruir_caminho();
    }

    public void reconstruir_caminho(){
        System.out.println("caminho do grafo: ");

        Integer[] caminho = new Integer[predecessor.length];
        int pos = predecessor.length-1, temp = 0;

        while(predecessor[pos] != null){
            caminho[temp] = pos;
            pos = predecessor[pos];
        }

        for (int i = caminho.length-1; i > 0; i--) {
            System.out.print(caminho[i] + " -> ");
        }
        System.out.println(";");

    }
}
