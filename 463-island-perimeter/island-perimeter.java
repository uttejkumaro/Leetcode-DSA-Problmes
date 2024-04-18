public class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        
        // Loop through each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Check if the cell is land
                if (grid[i][j] == 1) {
                    // Count how many sides of this land cell are exposed to water
                    perimeter += 4; // Start with assuming all sides are exposed
                    // Check left
                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2; // If the left cell is also land, subtract 2 (shared side)
                    // Check up
                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2; // If the upper cell is also land, subtract 2 (shared side)
                }
            }
        }
        
        return perimeter;
    }
}
