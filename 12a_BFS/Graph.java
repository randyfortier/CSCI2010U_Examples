import java.util.*;
import java.util.concurrent.*;

public class Graph {
   private class Vertex {
      private String name;
      private List<Vertex> adjacencies;
      private boolean discovered = false;
      private Vertex parent = null;

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

      public boolean isDiscovered() { return this.discovered; }
      public void setDiscovered(boolean newValue) { this.discovered = newValue; }

      public Vertex getParent() { return parent; }
      public void setParent(Vertex newParent) { this.parent = newParent; }
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

   public Vertex bfs(String startingVertexName, String goalVertexName) throws InterruptedException {
      Vertex startingVertex = vertices.get(startingVertexName);
      startingVertex.setParent(null);
      startingVertex.setDiscovered(true);

      LinkedBlockingQueue<Vertex> queue = new LinkedBlockingQueue<Vertex>();
      queue.put(startingVertex);

      while (queue.size() > 0) {
         Vertex v = queue.remove();

         // check if we have found the goal state
         if (v.getName().equals(goalVertexName)) {
            return v;
         }

         // search the adjacencies for v
         List<Vertex> adjacencies = v.getAdjacencies();
         for (Vertex w: adjacencies) {
            if (!w.isDiscovered()) {
               w.setDiscovered(true);
               w.setParent(v);
               queue.put(w);
            }
         }
      }

      return null;
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

      // test BFS
      try {
         System.out.println("Running BFS:");
         Vertex current = graph.bfs("E", "A");
         if (current == null) {
            System.out.println("No path found from E to A");
         } else {

            while (current != null) {
               System.out.print(current.getName() + " <- ");
               current = current.parent;
            }
         }
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
