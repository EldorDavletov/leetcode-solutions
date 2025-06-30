package graph;



import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {0, 4}};
//        Map<Integer, List<Integer>> graph = buildGraph(edges);
//
//        System.out.println(graph);

        int[][] trust = {{1,2}};
        System.out.println(findJudge(2,trust));
    }

    public static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // Add edge u -> v
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);

            // Add edge v -> u (for undirected graph)
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(u);
        }

        return graph;
    }



    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> graph = buildGraph(edges);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) return true;

            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    public static int findCenter(int[][] edges) {
        if (edges[0][0]==edges[1][0]) return edges[0][0];
        else if(edges[0][1] == edges[1][0]) {
            return edges[0][1];
        }else {
            return edges[0][0];
        }
    }


    public static int findJudge(int n, int[][] trust) {
        int[] in = new int[n];
        int[] out = new int[n];
        for(int[] row : trust ){
            in[row[1]-1]++;
            out[row[0]-1]++;
        }
        for(int i = 0; i < n; i++){
            if(out[i] == 0 && in[i] == n-1){
                return i + 1;
            }
        }

        return -1;
    }


}


