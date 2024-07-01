class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }        
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // Traverse from left to right along the top row
            for (int j = c1; j <= c2; j++) {
                list.add(matrix[r1][j]);
            }
            r1++;

            // Traverse from top to bottom along the right column
            for (int i = r1; i <= r2; i++) {
                list.add(matrix[i][c2]);
            }
            c2--;
            // Traverse from right to left along the bottom row, if there is a bottom row left to traverse
            if (r1 <= r2) {
                for (int j = c2; j >= c1; j--) {
                    list.add(matrix[r2][j]);
                }
            }
            r2--;
            // Traverse from bottom to top along the left column
            if (c1 <= c2) {
                for (int i = r2; i >= r1; i--) {
                    list.add(matrix[i][c1]);
                }
            }
            c1++;
        }

        return list;
    }
}
