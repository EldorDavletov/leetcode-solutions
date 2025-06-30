package graph;


import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class GraphExample {
    public static void main(String[] args) {
        Graph<String, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        // Tugunlarni qo'shish
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        // Qirralarni qo'shish
        Graphs.addEdgeWithVertices(graph, "A", "B", 1.0);
        Graphs.addEdgeWithVertices(graph, "B", "C", 2.0);
        Graphs.addEdgeWithVertices(graph, "A", "C", 4.0);

        // Eng qisqa yo'lni topish
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        System.out.println(dijkstra.getPath("A", "C"));
    }
}
