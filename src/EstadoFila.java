public class EstadoFila {
    final int vertice;
    final long distancia;

    EstadoFila(int vertice, long distancia) {
        this.vertice = vertice;
        this.distancia = distancia;
    }

    public int getVertice() {
        return vertice;
    }

    public long getDistancia() {
        return distancia;
    }
}
