// class Solution {
//     public long maxScore(int[] a, int[] b) {
//         int n=b.length;
//         long[][]dp =new long[5][n];
//         for (int i = 0; i <= 4; i++) {
//             for (int j = 0; j < n; j++) {
//                 dp[i][j] = Long.MIN_VALUE;
//             }
//         }
//         for (int j = 0; j < n; j++) {
//             dp[0][j] = 0;
//         }
//         for (int i = 1; i <= 4; i++) {  
//             for (int j = i - 1; j < n; j++) {  
                
//                 if (j > 0) {
//                     dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1] + (long) a[i-1] * b[j]);
//                 } else if (i == 1) {
//                     dp[i][j] = (long) a[0] * b[j];
//                 }
//             }
//         }

//         long result = Long.MIN_VALUE;
//         for (int j = 3; j < n; j++) { 
//             result = Math.max(result, dp[4][j]);
//         }

//         return result;
//     }
// }
class Solution {
    public long maxScore(int[] a, int[] b) {
        int n=b.length;
        int m=4;
        long memo[][]=new long[5][n+1];
        for(long row[]:memo) Arrays.fill(row,Long.MIN_VALUE);
        return solve(0,0,a,b,m,n,memo);
    }
    long solve(int i,int j,int a[],int b[],int m,int n ,long memo[][]){
        if(memo[i][j]!=Long.MIN_VALUE) return memo[i][j];
        if(i==4)return 0;
        if(j==b.length) return Long.MIN_VALUE;
        long notTake=solve(i,j+1,a,b,m,n,memo);
        long take=solve(i+1,j+1,a,b,m,n,memo);
        if(take!=Long.MIN_VALUE) {
            take+=(long)a[i]*b[j];
        }

        return memo[i][j]=Math.max(notTake,take);   



    }
}