class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        // Initialize adjacency list for graph representation
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph by connecting stones in the same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        int connectedComponents = 0;
        boolean[] visited = new boolean[n];

        // Traverse all stones to find and count connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                connectedComponents++;
            }
        }

        // Calculate the maximum number of stones that can be removed
        return n - connectedComponents;
    }

    // Recursive DFS to explore all stones in a connected component
    private void dfs(List<Integer>[] graph, boolean[] visited, int stone) {
        if (visited[stone]) return;
        visited[stone] = true;
        
        for (int neighbor : graph[stone]) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}