//FLOYD WARSHALL  ALGO 
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n=26;
        long  mat[][]=new long [n][n];
        //initialise
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    mat[i][j]=0; //same elements 
                }
                else{
                    mat[i][j] =Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<original.length;i++){
            int from =original[i]-'a';
            int to =changed[i]-'a';
            mat[from][to]=Math.min(mat[from][to],cost[i]);
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][k]!=Integer.MAX_VALUE && mat[k][j]!=Integer.MAX_VALUE){
                        mat[i][j]=Math.min( mat[i][j],mat[i][k]+mat[k][j]);
                    }
                }
            }        

        }
        long total=0;
        for(int i=0;i<source.length();i++){
            int from =source.charAt(i)-'a';
            int to  =target.charAt(i)-'a';
            if(mat[from][to]==Integer.MAX_VALUE) return -1;
              total+=mat[from][to];

        }
      
        return total;

        
    }
}