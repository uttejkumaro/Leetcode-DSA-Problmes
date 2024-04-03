class Solution {
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] visit = new boolean[x][y];
        boolean res = false;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res = backtracking(board, word, visit, i, j, 0);
                    if (res)
                        return true;
                }
            }
        }
        return false;
    }

    boolean backtracking(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if (backtracking(board, word, visited, i + 1, j, index + 1) ||
            backtracking(board, word, visited, i - 1, j, index + 1) ||
            backtracking(board, word, visited, i, j + 1, index + 1) ||
            backtracking(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
