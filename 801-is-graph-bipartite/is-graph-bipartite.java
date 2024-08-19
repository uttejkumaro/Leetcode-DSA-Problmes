class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int colors[]=new int[n];
        for(int i=0;i<n;i++){
            if(colors[i]==0){
                if(!dfs(graph,colors,i,1)){
                    return false;
                }
            }
        }
        return true;        
    }
    boolean dfs(int graph[][],int colors[],int node,int color){
        colors[node]=color;
        for(int neigh:graph[node]){
            if(colors[neigh]==0){
                 if (!dfs(graph, colors, neigh, -color)) {
                    return false;
                }
            } else if (colors[neigh] == color) { // if the neighbor is colored with the same color
                return false;
            }
        }

        return true;
    }
}