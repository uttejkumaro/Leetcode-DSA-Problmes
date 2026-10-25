class Solution {
    public int closedIsland(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        //convert boundary land os to 1s
        for(int i=0;i<n;i++){
            dfs(grid,i,0);
            dfs(grid,i,m-1);
        }
        for(int i=0;i<m;i++){
            dfs(grid,0,i);
            dfs(grid,n-1,i);
        }
        int count=0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==0){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
            return count;
    }
       
     void dfs(int grid [][],int i,int j){
        int n=grid.length;
        int m=grid[0].length;
            if(i<0|| j<0 || i>=n ||j>=m || grid[i][j]==1 )return;
            grid[i][j]=1;
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
         
        
    }
}