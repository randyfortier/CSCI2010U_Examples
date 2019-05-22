import java.util.*;

public class Graph {
   private class Vertex {
      private String name;
      private List<Vertex> adjacencies;

      public Vertex(String name) {
         this.name = name;
         adjacencies = new ArrayList<>();
      }

      public String getName() { return this.name; }

      public void addAdjacency(Vertex other) {
         adjacencies.add(other);
      }

      public List<Vertex> getAdjacencies() { return adjacencies; }

      public int getDegree() {
         return adjacencies.size();
      }
   }

   private class Edge {
      private Vertex v1;
      private Vertex v2;

      public Edge(Vertex v1, Vertex v2) {
         this.v1 = v1;
         this.v2 = v2;
      }

      public Vertex getVertex1() { return v1; }
      public Vertex getVertex2() { return v2; }
   }

   private HashMap<String, Vertex> vertices;

   public Graph() {
      vertices = new HashMap<>();
   }

   public void addVertex(String name) {
      vertices.put(name, new Vertex(name));
   }

   public void addEdge(String v1name, String v2name) {
      // collect the references to each vertex
      Vertex v1 = vertices.get(v1name);
      Vertex v2 = vertices.get(v2name);

      // add an adjacency from v1 to v2 AND an adjacency from v2 to v1
      v1.addAdjacency(v2);
      v2.addAdjacency(v1);
   }

   public Vertex getVertex(String name) {
      return vertices.get(name);
   }

   // implement DFS

   public static void main(String[] args) {
      Graph graph = new Graph();

      graph.addVertex("A");
      graph.addVertex("B");
      graph.addVertex("C");
      graph.addVertex("D");
      graph.addVertex("E");

      graph.addEdge("A", "B");
      graph.addEdge("A", "C");
      graph.addEdge("B", "D");
      graph.addEdge("C", "D");
      graph.addEdge("B", "E");
      graph.addEdge("D", "E");

      // test DFS
   }
}
