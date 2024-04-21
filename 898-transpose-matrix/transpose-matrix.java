class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // Creating a new matrix to store the transposed values
        int[][] result = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Transpose the values
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
