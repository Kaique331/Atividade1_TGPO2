public class FloydWarshall {
    public final int inf = 999999999;
    int[][] distancia, next;
    Graph grafo;

    public FloydWarshall(Graph grafo){
        this.grafo = grafo;
        this.distancia = grafo.getCustos().clone();
        this.next = new int[grafo.getVertices()][grafo.getVertices()];
    }

    public void floydwarshall(){
        for(Edge aresta: grafo.getEdges()){
            next[aresta.from][aresta.to] = aresta.to;
        }

        for (int k = 0; k < grafo.getVertices()-1; k++) {
            for (int j = 0; j < grafo.getVertices() -1; j++) {
                for (int i = 0; i < grafo.getVertices()-1; i++) {
                    if(distancia[i][k] == inf | distancia[k][j] == inf){
                        continue;
                    }
                    int candidato = distancia[i][k]+distancia[k][j];
                    if(candidato < distancia[i][j]){
                        distancia[i][j] = candidato;
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < grafo.getVertices()-1; i++) {
            for (int j = 0; j < grafo.getVertices()-1; j++) {
                if(distancia[i][j] < 0){
                    System.out.println("há ciclo negativo");
                }
            }
        }
    }
}
