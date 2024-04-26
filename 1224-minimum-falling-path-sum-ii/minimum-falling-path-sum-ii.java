class Solution {
    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;

        int m = grid[0].length;

        int dp[][] = new int [n][m];

        //fill the base case

        for(int col = 0; col < m ; col++){

            dp[n-1][col] = grid[n-1][col];

        }

        for(int row = n-2 ; row >= 0 ; row--){

            for(int col = 0; col <m; col++){

                int min_el = Integer.MAX_VALUE;

                for(int i = 0; i< m ; i++){

                    if(i != col){

                        min_el = Math.min(min_el,dp[row+1][i]);

                    }
                }
                dp[row][col] = grid[row][col] + min_el;
            }

        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < m ; i++){

            ans = Math.min(ans,dp[0][i]);
        }

        return ans;
        
    }
}