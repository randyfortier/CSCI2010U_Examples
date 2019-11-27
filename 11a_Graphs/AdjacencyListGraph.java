import java.util.*;

public class AdjacencyListGraph {
    private class Vertex {
        private String name;
        private List<Vertex> adjacencies;

        public Vertex(String name) {
            this.name = name;
            adjacencies = new ArrayList<>();
        }

        public String getName() { return name; }

        public void addAdjacency(Vertex other) {
            adjacencies.add(other);
        }

        public List<Vertex> getAdjacencies() {
            return adjacencies;
        }

        public int getDegree() {
            return adjacencies.size();
        }
    }

    private HashMap<String,Vertex> vertices;

    public AdjacencyListGraph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String name) {
        vertices.put(name, new Vertex(name));
    }

    public void addEdge(String v1name, String v2name) {
        // lookup the vertices
        Vertex v1 = vertices.get(v1name);
        Vertex v2 = vertices.get(v2name);

        // add an adjacency of v2 to v1
        v1.addAdjacency(v2);

        // add an adjacency of v1 to v2
        v2.addAdjacency(v1);
    }

    public Vertex getVertex(String name) {
        return vertices.get(name);
    }

    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");

        Vertex d = graph.getVertex("D");
        System.out.println("Degree of D: " + d.getDegree());

        List<Vertex> adjacencies = d.getAdjacencies();
        System.out.println("Adjacencies of D:");
        for (Vertex v : adjacencies) {
            System.out.println("\t" + v.getName());

            System.out.print("\t" + v.getName() + "'s adjacencies:");
            for (Vertex x: v.getAdjacencies()) {
                System.out.print(x.getName() + " ");
            }
            System.out.println("");
        }
    }
}