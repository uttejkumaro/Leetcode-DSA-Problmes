//VSISITED NODE IS MARKED AS 2
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

        //  if (i < 0 || i > grid.length-1|| j < 0 || j > grid[0].length-1 || grid[i][j] == '0') {
         if (i < 0 || i > grid.length-1|| j < 0 || j > grid[0].length-1 || grid[i][j] !='1') {
            return;
        }
        //  if (grid[i][j]=='2') {
        //     return;
        //}
        // grid[i][j]='2';
        // //up
        // dfs(grid,i-1,j);
        // //right
        // dfs(grid,i,j+1);
        // //down
        // dfs(grid,i+1,j);
        // //left
        // dfs(grid,i,j-1);
        grid[i][j] = '0'; // Mark as visited (turn land into water)
         int[] dirX = {-1, 0, 1, 0}, dirY = {0, 1, 0, -1};
        for (int d = 0; d < 4; d++) 
            dfs(grid, i + dirX[d], j + dirY[d]);
            /**
             int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
        } */

    }
}
/*
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, directions);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '2'; // mark as visited

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == '1') {
                    queue.add(new int[]{newX, newY});
                    grid[newX][newY] = '2'; // mark as visited
                }
            }
        }
    }
}
*/