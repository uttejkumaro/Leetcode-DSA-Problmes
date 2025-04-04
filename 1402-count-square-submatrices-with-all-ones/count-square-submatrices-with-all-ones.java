class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int [][]subMatrices=new int[n][m];
        for(int i=0;i<n;i++) subMatrices[i][0]=matrix[i][0];
        for(int i=0;i<m;i++) subMatrices[0][i]=matrix[0][i];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0) subMatrices[i][j]=0;
                else{
                    subMatrices[i][j]=1+Math.min(subMatrices[i-1][j],Math.min(subMatrices[i][j-1],subMatrices[i-1][j-1]));
                }
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=subMatrices[i][j];
            }
        }
        return sum;
        
    }
}