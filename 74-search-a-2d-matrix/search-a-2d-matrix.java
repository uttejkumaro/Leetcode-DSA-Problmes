class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row * col - 1;
        
        // Binary search
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = matrix[mid / col][mid % col];
            
            if (midVal == target) {
                return true;
            } else if (midVal > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return false;
    }
}
