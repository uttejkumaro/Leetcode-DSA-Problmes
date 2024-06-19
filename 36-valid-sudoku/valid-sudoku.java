
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Arrays of hash sets to track numbers in each row, column, and block
        HashSet<String>[] rows = new HashSet[9];
        HashSet<String>[] cols = new HashSet[9];
        HashSet<String>[] blocks = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            blocks[i] = new HashSet<>();
        }
        
        // Iterate through each cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value != '.') {
                    String valStr = String.valueOf(value);
                    
                    // Check row
                    if (!rows[i].add(valStr)) {
                        return false;
                    }
                    
                    // Check column
                    if (!cols[j].add(valStr)) {
                        return false;
                    }
                    
                    // Check block
                    int blockIndex = (i / 3) * 3 + j / 3;
                    if (!blocks[blockIndex].add(valStr)) {
                        return false;
                    }
                }
            }
        }
        
        return true; // Board is valid
    }
}
