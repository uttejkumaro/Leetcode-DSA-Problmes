class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []connection:connections){
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }
        boolean vis[]=new boolean[n];
        int components=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                components++;
            }
        }
        return components-1;
       
 
    }
    void dfs(int i,List<List<Integer>>adj,boolean[] vis){
        vis[i]=true;
        for(int j:adj.get(i)){
            if(!vis[j]){
                dfs(j,adj,vis);
            }
        }
    }
}