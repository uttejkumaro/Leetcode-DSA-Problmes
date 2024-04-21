import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create adjacency list representation of the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Since it's a bidirectional graph
        }
        
        // Initialize visited array
        boolean[] visited = new boolean[n];
        
        // DFS from source vertex
        return dfs(adjList, visited, source, destination);
    }
    
    private boolean dfs(List<List<Integer>> adjList, boolean[] visited, int current, int destination) {
        // Mark the current node as visited
        visited[current] = true;
        
        // If current node is the destination, return true
        if (current == destination) {
            return true;
        }
        
        // Iterate through all neighbors of current node
        for (int neighbor : adjList.get(current)) {
            // If neighbor is not visited, recursively call DFS on it
            if (!visited[neighbor]) {
                if (dfs(adjList, visited, neighbor, destination)) {
                    return true; // If valid path found, return true
                }
            }
        }
        
        // If no valid path found, return false
        return false;
    }
}
