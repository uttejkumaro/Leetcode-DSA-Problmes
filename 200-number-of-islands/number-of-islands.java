class Solution {
    public int numIslands(char[][] grid) {
        int count=0;

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length ; j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

        return count;
        
    }


    public void dfs(char[][] grid,int i,int j)
    {
        // boundary check and island visited check

         if (i < 0 || i > grid.length-1|| j < 0 || j > grid[0].length-1 || grid[i][j] == '0') {
            return;
        }

         if (grid[i][j]=='2') {
            return;
        }

        grid[i][j]='2';
        //up
        dfs(grid,i-1,j);
        //right
        dfs(grid,i,j+1);
        //down
        dfs(grid,i+1,j);
        //left
        dfs(grid,i,j-1);

    }
}