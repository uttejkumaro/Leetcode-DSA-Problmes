// class Solution {
//     public int[] rowAndMaximumOnes(int[][] mat) {
//         int n = mat.length;
//         int m = mat[0].length;
//         int maxOnes = 0;
//         int rowIndex = 0;

//         for (int i = 0; i < n; i++) {
//             int ones = 0;
//             for (int j = 0; j < m; j++) {
//                 if (mat[i][j] == 1) {
//                     ones++;
//                 }
//             }
//             if (ones > maxOnes) {
//                 maxOnes = ones;
//                 rowIndex = i; // store row with highest ones
//             }
//         }
//         return new int[]{rowIndex, maxOnes};
//     }
// }
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int rowIndex = 0, maxOnes = 0;
        for (int i = 0; i < mat.length; i++) {
            int ones = Arrays.stream(mat[i]).sum(); // counts ones directly
            if (ones > maxOnes) {
                maxOnes = ones;
                rowIndex = i;
            }
        }
        return new int[]{rowIndex, maxOnes};
    }
}
