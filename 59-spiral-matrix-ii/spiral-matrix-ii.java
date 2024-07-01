class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int num = 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int j = c1; j <= c2; j++) {
                matrix[r1][j] = num++;
            }
            r1++;
            
            for (int i = r1; i <= r2; i++) {
                matrix[i][c2] = num++;
            }
            c2--;

            if (r1 <= r2) {
                for (int j = c2; j >= c1; j--) {
                    matrix[r2][j] = num++;
                }
            }
            r2--;

            if (c1 <= c2) {
                for (int i = r2; i >= r1; i--) {
                    matrix[i][c1] = num++;
                }
            }
            c1++;
        }

        return matrix;
    }
}
