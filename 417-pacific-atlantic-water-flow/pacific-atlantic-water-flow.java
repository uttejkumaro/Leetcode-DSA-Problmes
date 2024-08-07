class Solution {
    
    private void visitNeighbours(int row, int col, boolean[][] ocean, int[][] heights) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int n = heights.length;
        int m = heights[0].length;
        
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{row, col});
        
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            int x = curr[0];
            int y = curr[1];
            
            for (int[] direction: directions) {
                int newRow = direction[0] + x;
                int newCol = direction[1] + y;
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && heights[x][y] <= heights[newRow][newCol] && !ocean[newRow][newCol]) {
                    Q.add(new int[]{newRow, newCol});
                    ocean[newRow][newCol] = true;
                }
            }
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        for (int col = 0; col < m; col++) {
            // top most row
            visitNeighbours(0, col, pacific, heights);
            
            // bottom most row
            visitNeighbours(n - 1, col, atlantic, heights);
        }
        
        for (int row = 0; row < n; row++) {
            // left most col
            visitNeighbours(row, 0, pacific, heights);
            
            // right most col
            visitNeighbours(row, m - 1, atlantic, heights);
        }
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(row);
                    curr.add(col);
                    result.add(curr);
                }
            }
        }
        
        return result;
    }
}