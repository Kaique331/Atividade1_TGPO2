public class Edge {
    int from;
    int to;
    int weight;
    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public int getFrom(){
        return from;
    }

    public int getTo(){
        return to;
    }
}
