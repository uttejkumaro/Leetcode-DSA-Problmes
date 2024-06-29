class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ancestors = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            ancestors.add(new ArrayList<>());
            graph[i] = new ArrayList<>();
        }

        // Build the graph
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }

        // Perform DFS for each node
        for (int node = 0; node < n; ++node) {  // Fixed the variable being incremented
            boolean[] seen = new boolean[n];
            dfs(graph, node, node, seen, ancestors);
        }

        // Sort each list of ancestors
        for (List<Integer> ancestorList : ancestors) {
            Collections.sort(ancestorList);
        }

        return ancestors;
    }

     void dfs(List<Integer>[] graph, int currentNode, int ancestor, boolean[] seen,
                     List<List<Integer>> ancestors) {
        seen[currentNode] = true;
        for (int neighbor : graph[currentNode]) {
            if (!seen[neighbor]) {
                ancestors.get(neighbor).add(ancestor);
                dfs(graph, neighbor, ancestor, seen, ancestors);
            }
        }
    }
}
