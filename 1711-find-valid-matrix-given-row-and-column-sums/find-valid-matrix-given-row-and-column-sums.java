class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n=rowSum.length,m=colSum.length;
        
        int[][] restoreMatrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int fill=Math.min(rowSum[i],colSum[j]);
                restoreMatrix[i][j]=fill;
                rowSum[i]-=fill;
                colSum[j]-=fill;
            }
        }
        return restoreMatrix;

    }
}