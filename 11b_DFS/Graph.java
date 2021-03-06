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

   public Set<Vertex> discovered;
   public Map<Vertex,Edge> edges;

   public void dfs(String startingVertexName) {
      Vertex startingVertex = vertices.get(startingVertexName);

      discovered = new HashSet<>();
      edges = new HashMap<>();

      dfs(startingVertex);
   }

   private void dfs(Vertex vert) {
      discovered.add(vert);

      List<Vertex> adjacencies = vert.getAdjacencies();
      for (Vertex v: adjacencies) {
         if (!discovered.contains(v)) {
            edges.put(v, new Edge(v, vert));
            dfs(v);
         }
      }
   }

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

      Vertex d = graph.getVertex("D");
      System.out.println("degree of D: " + d.getDegree());
      List<Vertex> adjacencies = d.getAdjacencies();
      System.out.println("Adjacencies of D: ");
      for (Vertex v: adjacencies) {
         System.out.print("\t" + v.getName() + ", adjacencies: ");

         for (Vertex a: v.getAdjacencies()) {
            System.out.print("\t\t" + a.getName() + " ");
         }
         System.out.println("");
      }

      // test DFS
      graph.dfs("E");

      System.out.println("Discovered vertices: ");
      for (Vertex v: graph.discovered) {
         System.out.println("\t" + v.getName());
      }

      System.out.println("Discovered edges: ");
      for (Vertex v: graph.edges.keySet()) {
         Edge e = graph.edges.get(v);
         System.out.println("\t(" + e.getVertex1().getName() + ", " + e.getVertex2().getName() + ")");
      }
   }
}
