package graph;

import java.util.*;

public class SimpleGraph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addVertex(String label){
        adjList.putIfAbsent(label,new ArrayList<>());
    }

    public void addEdge(String src, String dest){
        adjList.get(src).add(dest);
    }


    // Eng qisqa yo'lni Dijkstra algoritmi orqali topish
    public List<String> getShortestPath(String start, String end) {
        Set<String> visited = new HashSet<>();
        Map<String, String> previousNodes = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();

            if (node.equals(end)) {
                return buildPath(previousNodes, start, end);
            }

            for (String neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    previousNodes.put(neighbor, node);
                    queue.add(neighbor);
                }
            }
        }

        return Collections.emptyList(); // Yo'l topilmasa, bo'sh ro'yxat qaytariladi
    }

    private List<String> buildPath(Map<String, String> previousNodes, String start, String end) {
        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = previousNodes.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }


    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");
        graph.addEdge("C", "D");

        System.out.println("Shortest path from A to D: " + graph.getShortestPath("A", "D"));

    }
}
