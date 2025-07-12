// class Solution {
//     public int countCompleteComponents(int n, int[][] edges) {
//         //ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
//         ArrayList<Integer>[] graph = new ArrayList[n];
//             for (int i = 0; i < n; i++) {
//             graph[i] = new ArrayList<>();
//             }
//             for (int[] edge : edges) {
//                 int u = edge[0];
//                 int v = edge[1];
//                 graph [u].add(v);
//                 graph [v].add(u);
//             }
//         int count=0;
//         boolean vis[]=new boolean[n];
//         for(int i=0;i<n;i++){
//             if(!vis[i]){
//                 count++;
//                 dfs(n,graph,i,vis);
//             }
//         }
//         return count;
//     }
//     void  dfs(int n, ArrayList<Integer>[] graph,int i,boolean vis[]){
//         vis[i]=true;
//         for(int neigh:graph [i]){
//             if(!vis[neigh]){
//                 dfs(n,graph,neigh,vis);
//             }
//         }
//     }
// }
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> nodes = new ArrayList<>();
                dfs(graph, i, vis, nodes);

                int numNodes = nodes.size();
                int edgeCount = 0;

                for (int node : nodes) {
                    edgeCount += graph[node].size();
                }
                edgeCount /= 2; // Each edge counted twice in adjacency list

                int expectedEdges = numNodes * (numNodes - 1) / 2;
                if (edgeCount == expectedEdges) {
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(ArrayList<Integer>[] graph, int u, boolean[] vis, List<Integer> nodes) {
        vis[u] = true;
        nodes.add(u);
        for (int v : graph[u]) {
            if (!vis[v]) {
                dfs(graph, v, vis, nodes);
            }
        }
    }
}
