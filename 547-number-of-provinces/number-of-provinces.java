// // class Solution {
// //     private void dfs(int[][] isConnected, boolean[] visited, int i) {
// //         visited[i] = true;
// //         for (int j = 0; j < isConnected.length; j++) {
// //             if (isConnected[i][j] == 1 && !visited[j]) {
// //                 dfs(isConnected, visited, j);
// //             }
// //         }
// //     }
// //     public int findCircleNum(int[][] isConnected) {
// //         int n= isConnected.length;
// //         boolean []visited=new boolean[n];
// //         int count=0;
// //         for(int i=0;i<n;i++){
// //             if(!visited[i]){
// //                 count++;
// //                 dfs(isConnected,visited,i);
// //             }
// //         }    
// //         return count;    
// //     }

// // }
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//           int n= isConnected.length;
//         boolean []vis=new boolean[n];
//         int count=0;
//         Queue<Integer>q=new LinkedList<>();
//         for(int i=0;i<n;i++){
//             if(!vis[i]){
//                 vis[i]=true;
//                 q.add(i);
//                 while(!q.isEmpty()){
//                     int city=q.poll();
//                     for(int j=0;j<n;j++){
//                         if(isConnected[city][j]==1 && !vis[j]){
//                             vis[j]=true;
//                             q.add(j);
//                         }
//                     }

//                 }
//                             count++;
//             }
//         }
//         return count;
//     }
  
// }

class Solution {
    void dfs(boolean visited[],int node,int[][]isConnected){
        visited[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i]==1 && !visited[i]){
                dfs(visited,i,isConnected);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(visited,i,isConnected);
                count++;
            }
        }
        return count;

    }
}
/**

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                if (isConnected[node][neighbor] == 1 && !visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
 */