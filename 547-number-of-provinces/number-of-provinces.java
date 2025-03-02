// class Solution {
//     private void dfs(int[][] isConnected, boolean[] visited, int i) {
//         visited[i] = true;
//         for (int j = 0; j < isConnected.length; j++) {
//             if (isConnected[i][j] == 1 && !visited[j]) {
//                 dfs(isConnected, visited, j);
//             }
//         }
//     }
//     public int findCircleNum(int[][] isConnected) {
//         int n= isConnected.length;
//         boolean []visited=new boolean[n];
//         int count=0;
//         for(int i=0;i<n;i++){
//             if(!visited[i]){
//                 count++;
//                 dfs(isConnected,visited,i);
//             }
//         }    
//         return count;    
//     }

// }
class Solution {
    public int findCircleNum(int[][] isConnected) {
          int n= isConnected.length;
        boolean []vis=new boolean[n];
        int count=0;
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                q.add(i);
                while(!q.isEmpty()){
                    int city=q.poll();
                    for(int j=0;j<n;j++){
                        if(isConnected[city][j]==1 && !vis[j]){
                            vis[j]=true;
                            q.add(j);
                        }
                    }

                }
                            count++;
            }
        }
        return count;
    }
  
}