class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;        
        int m = image[0].length;     
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        
        bfs(image, sr, sc, color, originalColor, n, m);
        return image;
    }

    private void bfs(int[][] image, int r, int c, int color, int originalColor, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        image[r][c] = color;
        
        // Directions for moving in the grid (Right, Down, Left, Up)
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int x = pixel[0];
            int y = pixel[1];
            
            for (int dir[]:directions) {

                int newRow = x + dir[0];
                int newCol = y + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && image[newRow][newCol] == originalColor) {
                    image[newRow][newCol] = color;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
