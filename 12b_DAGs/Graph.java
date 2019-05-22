import java.util.*;
import java.util.concurrent.*;

public class Graph {
   private class Vertex {
      private String name;
      private List<Vertex> adjacencies;
      private int label = -1;

      public Vertex(String name) {
         this.name = name;
         adjacencies = new ArrayList<>();
      }

      public String getName() { return this.name; }

      public void addAdjacency(Vertex other) {
         adjacencies.add(other);
      }

      public void removeAdjacency(Vertex other) {
         adjacencies.remove(other);
      }

      public List<Vertex> getAdjacencies() { return adjacencies; }

      public int getDegree() {
         return adjacencies.size();
      }

      public int getLabel() { return label; }
      public void setLabel(int newLabel) { this.label = newLabel; }
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
      //v2.addAdjacency(v1);  // edges are one-directional in a DAG
   }

   public HashMap<String, Vertex> getVertices() { return vertices; }

   public void removeEdgesIntoVertex(Vertex endVertex) {
      Set<String> vertexNames = this.vertices.keySet();
      for (String key: vertexNames) {
         Vertex v = this.vertices.get(key);
         v.removeAdjacency(endVertex);
      }
   }

   public Vertex getVertex(String name) {
      return vertices.get(name);
   }

   public void topologicalSort() {
      Set<String> vertexNames = this.vertices.keySet();

      // for quick access
      List<Vertex> vertices = new ArrayList<>();
      for (String key: vertexNames) {
         vertices.add(this.vertices.get(key));
      }

      while (vertices.size() > 0) {
         // find a vertex with no outgoing edges
         Vertex nextVertex = null;
         for (Vertex v: vertices) {
            if (v.getDegree() == 0) {
               nextVertex = v;
            }
         }

         if (nextVertex != null) {
            nextVertex.setLabel(vertices.size());
            vertices.remove(nextVertex);
            this.removeEdgesIntoVertex(nextVertex);
         } else {
            System.out.println("No vertices with degree zero found.");
            return;
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

      graph.addEdge("B", "A");
      graph.addEdge("A", "C");
      graph.addEdge("C", "D");
      graph.addEdge("B", "D");
      graph.addEdge("B", "E");
      graph.addEdge("D", "E");

      // test topological sorting
      graph.topologicalSort();

      // for quick access
      Set<String> vertexNames = graph.vertices.keySet();
      List<Vertex> vertices = new ArrayList<>();
      for (String key: vertexNames) {
         vertices.add(graph.vertices.get(key));
      }

      // output the sorted vertices, in order
      for (int i = 1; i <= vertexNames.size(); i++) {
         for (Vertex v: vertices) {
            if (v.getLabel() == i) {
               System.out.print(v.getName() + " ");
            }
         }
      }
   }
}
