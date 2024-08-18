class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int memo[][]=new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=-1;
            }
        }
        return lps(s,0,n-1,memo);
        
    }
    int lps(String s,int i,int j,int memo[][]){
        if(i>j){
            return 0;
        }
        if(i==j){
            //1 length case
            return 1;
        }
        if(memo[i][j]!=-1) return memo[i][j];
        if(s.charAt(i)==s.charAt(j)){
            memo[i][j]=2+lps(s,i+1,j-1,memo);
        }
        else{
            memo[i][j]=Math.max(lps(s,i+1,j,memo),lps(s,i,j-1,memo));
        }
        return memo[i][j];
    }
}