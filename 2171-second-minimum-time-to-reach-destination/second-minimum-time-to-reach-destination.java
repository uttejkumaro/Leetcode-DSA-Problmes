class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            
            for (int v : graph.get(u)) {
                int nd = d + time;
                if ((d / change) % 2 == 1) {
                    nd += change - (d % change);
                }
                
                if (nd < dist[v][0]) {
                    dist[v][1] = dist[v][0];
                    dist[v][0] = nd;
                    pq.offer(new int[]{v, nd});
                } else if (nd > dist[v][0] && nd < dist[v][1]) {
                    dist[v][1] = nd;
                    pq.offer(new int[]{v, nd});
                }
            }
        }
        
        return dist[n - 1][1];
    }
}
