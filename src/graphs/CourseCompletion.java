package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseCompletion {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}, {1, 3}}; // This has a cycle
        boolean canFinish = canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + canFinish);
    }

    /**
     * This method determines if it's possible to finish all courses given the prerequisites.
     * The algorithm works as below:
     * 1. Build a graph from the prerequisites.
     * 2. Use DFS to detect cycles in the graph.
     * 3. If a cycle is detected, return false. If no cycles are found, return true.
     * 
     * @param numCourses number of courses
     * @param prerequisites list of prerequisite pairs
     * @return true if all courses can be finished, false otherwise
     */
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (courseSchedule(course, visited, graph) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to perform DFS and detect cycles.
     * The method works as below:
     * 1. If the course is already in the visited set, a cycle is detected.
     * 2. If the course has no prerequisites, return true.
     * 3. Add the course to the visited set and recursively visit all its neighbors.
     * 4. After visiting all neighbors, remove the course from the visited set and mark it as completed by removing it from the graph.
     * 5. Return true if no cycles are detected.
     * 
     * @param course course to check
     * @param visited set of currently visited nodes in the DFS path
     * @param graph adjacency list representation of the graph
     * @return true if no cycles are detected, false otherwise
     */
    private static boolean courseSchedule(int course, HashSet<Integer> visited, HashMap<Integer, List<Integer>> graph) {
        if (visited.contains(course)) {
            return false; // Cycle detected
        }
        if (!graph.containsKey(course)) {
            return true; // No prerequisites
        }

        visited.add(course);
        for (int neighbor : graph.get(course)) {
            if (courseSchedule(neighbor, visited, graph) == false) {
                return false;
            }
        }
        visited.remove(course);
        graph.remove(course); // Mark as completed
        return true;
    }
}
