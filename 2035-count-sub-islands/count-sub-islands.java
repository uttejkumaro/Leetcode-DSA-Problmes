class Solution {
    public boolean checkSubIsland(int[][] grid1,int[][] grid2,int i,int j){
        if(i<0 || i>=grid2.length || j<0 || j>=grid2[0].length ){
            return true;
        }

        if(grid2[i][j] != 1){
            return true;
        }

         grid2[i][j] = -1;
         
         boolean result = (grid1[i][j] == 1) ;
        result = result & checkSubIsland(grid1, grid2, i - 1, j);  // Up
        result = result & checkSubIsland(grid1, grid2, i, j + 1);  // Right
        result = result & checkSubIsland(grid1, grid2, i + 1, j);  // Down
        result = result & checkSubIsland(grid1, grid2, i, j - 1);  // Left

         return result;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
         
         int ans = 0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j] == 1 && checkSubIsland(grid1,grid2,i,j)){
                    ans++;
                }
            }
         }

         return ans;
    }
}