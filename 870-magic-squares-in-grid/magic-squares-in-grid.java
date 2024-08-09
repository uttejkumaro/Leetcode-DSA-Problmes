class Solution {
    private boolean isMagic(int[][] grid, int row, int col) {
        // Check the center of the 3x3 grid
        if (grid[row + 1][col + 1] != 5) {
            return false;
        }
        // To check for distinct numbers 1 to 9
        boolean[] seen = new boolean[10]; 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        int sum = 15; // Expected sum for each row, column, and diagonal
        return (grid[row][col] + grid[row][col + 1] + grid[row][col + 2] == sum) && // row 1
               (grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2] == sum) && // row 2
               (grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] == sum) && // row 3
               (grid[row][col] + grid[row + 1][col] + grid[row + 2][col] == sum) && // column 1
               (grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1] == sum) && // column 2
               (grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2] == sum) && // column 3
               (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] == sum) && // diagonal 1
               (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] == sum); // diagonal 2
    }
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
