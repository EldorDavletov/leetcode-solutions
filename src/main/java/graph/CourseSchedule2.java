package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public static void main(String[] args) {

    }




    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build Graph and indegree array
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course); // prereq → course
            indegree[course]++;
        }

        // Step 2: Initialize queue with 0-indegree nodes
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);

        // Step 3: Process courses
        int completed = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[completed++] = curr;

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.add(neighbor);
            }
        }

        return completed == numCourses ? result : new int[]{};
    }


}
