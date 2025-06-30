package graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph {

    public static void main(String[] args) {

    }


    public Node cloneGraphBFS(Node node) {
        if (node == null) return null;

        Map<Node,Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node cloned = new Node(node.val,new ArrayList<>());
        visited.put(node,cloned);
        queue.add(node);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            for (Node neighbor : current.neighbors){
                if (!visited.containsKey(neighbor)){
                    visited.put(current,new Node(neighbor.val,new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }
        return cloned;
    }

    // dfs approach
    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) return visited.get(node);

        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
