class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }    
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // If the cell is empty
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        // Check if placing num at board[row][col] is valid
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place num
                            
                            // Recursively attempt to fill the board
                            if (solve(board)) {
                                return true;
                            }
                            
                            board[row][col] = '.'; // Undo placement (backtrack)
                        }
                    }
                    return false; // No valid number found, trigger backtracking
                }
            }
        }
        return true; // All cells are filled
    }    
    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check if num is not in the current row, column, and 3x3 sub-grid
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num || 
                board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
