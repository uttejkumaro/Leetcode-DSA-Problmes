import java.util.*;

class Solution {
    public class Edge {
        int src;
        int dest;
        int wt; // Weight

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public void createGraph(ArrayList<Edge>[] graph, int[][] edges, int n) {
        // Initialize
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

            graph[src].add(new Edge(src, dest, 1));
            graph[dest].add(new Edge(dest, src, 1));
        }
    }

    public class Pair implements Comparable<Pair> {
        int node;
        int distance;

        public Pair(int n, int d) {
            this.node = n;
            this.distance = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.distance - p2.distance;
        }
    }

    public int Dijkstra(ArrayList<Edge>[] graph, int src, int n) {
        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] vis = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        dist[src] = 0; // Distance from source to itself is 0

        // BFS
        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            if (!vis[current.node]) {
                // Visit it first
                vis[current.node] = true;

                // Go to its neighbours
                for (Edge e : graph[current.node]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[v] > (dist[u] + wt)) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        // Now return the distances
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dist[i];
        }
        return sum;
    }

    public int getChildren(ArrayList<Edge>[] graph, int src, boolean[] visited, int[] children) {
        visited[src] = true;
        int ans = 0;
        for (Edge e : graph[src]) {
            if (!visited[e.dest]) {
                ans += (getChildren(graph, e.dest, visited, children) + 1);
            }
        }
        return children[src] = ans;
    }

    public void dfs(ArrayList<Edge>[] graph, int src, int parent, int n, int[] ans, boolean[] visited, int[] children) {
        visited[src] = true;
        if (parent != -1) {
            int child = children[src];
            int non_child = n - child - 1; //-1 because we have to exclude our current node which is parent
            child++; // Adding our current node as child
            int parent_dis = ans[parent];
            ans[src] = parent_dis + non_child - child;
        }
        // Now Its neighbours
        for (Edge e : graph[src]) {
            if (!visited[e.dest]) {
                dfs(graph, e.dest, src, n, ans, visited, children);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (edges.length == 0) {
            int[] a = { 0 };
            return a;
        }
        // Create Graph using Adjacency List
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, edges, n);

        int[] ans = new int[n]; // Answer Array
        ans[0] = Dijkstra(graph, 0, n);

        // Visited array
        boolean[] visited = new boolean[n];

        // Number of children of each node
        int[] children = new int[n];
        getChildren(graph, 0, visited, children);

        // Now find the answer for all other nodes using root node 0. i.e ans[node]
        Arrays.fill(visited, false);
        dfs(graph, 0, -1, n, ans, visited, children);

        return ans;
    }
}