// class Solution {
//     public boolean findSafeWalk(List<List<Integer>> grid, int health) {
//         int n=grid.size();
//         int m=grid.get(0).size();
//         int dir[][]={{1,0},{0,-1},{-1,0},{0,1}};
//         Queue<int []>queue=new LinkedList<>();
//         boolean vis[][]=new boolean[n][m];
//         queue.offer(new int[]{0,0,health});
//         vis[0][0]=true;
//         while(!queue.isEmpty()){
//             int curr[]=queue.poll();
//             int x=curr[0];
//             int y=curr[1];
//             int currHealth=curr[2];
//             if(x==n-1 && y==m-1 && currHealth>=1) return true;
//             for(int []d:dir){
//                 int newX=x+d[0];
//                 int newY=y+d[1];
            
//             if(newX>=0 && newY>=0 && newX<n && newY<m && !vis[newX][newY]){
//                 int newHealth=currHealth-grid.get(newX).get(newY);
//                 if(newHealth>=1){
//                     queue.offer(new int[]{newX,newY,newHealth});
//                     vis[newX][newY]=true;
//                 }
//             }
//             }
//         }
//         return false;        
//     }
// }
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();
        int[][] visited=new int[m][n];
        int[][][] dp=new int[m][n][health+1];
        for(int[][] arr:dp){
            for(int[] nums:arr){
                Arrays.fill(nums,-1);
            }
        }
        return func(m-1,n-1,grid,health,visited,dp);
    }
    public boolean func(int i,int j,List<List<Integer>> grid,int health,int[][] visited,int [][][] dp){
        if(i<0 || j<0 || i>=grid.size() || j>=grid.get(0).size()) return false;
        if(i==0 && j==0){
            if(grid.get(i).get(j)==0 && health>=1) return true;
            else{
                if(health>=2) return true;
                return false;
            }
        }
        if(health<0 || visited[i][j]==1) return false;
        if(dp[i][j][health]!=-1) return dp[i][j][health]==1?true:false;
        int a=grid.get(i).get(j);
        visited[i][j]=1;
        boolean p=func(i-1,j,grid,health-a,visited,dp);
        if(p) return true;
        boolean q=func(i,j-1,grid,health-a,visited,dp);
        if(q) return true;
        boolean r=func(i+1,j,grid,health-a,visited,dp);
        if(r) return true;
        boolean s=func(i,j+1,grid,health-a,visited,dp);
        visited[i][j]=0;
        boolean ans=p|q|r|s;
        if(ans==true) dp[i][j][health]=1;
        else dp[i][j][health]=0;
        
        return ans;
    }
}