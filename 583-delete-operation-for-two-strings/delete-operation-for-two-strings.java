class Solution {
    public int minDistance(String word1, String word2) {
        int len=longestCommonSub(word1,word2);
        //inse-m-len
        //del-n-len
        return word1.length()+word2.length()-(2*len);
        
    }
    int longestCommonSub(String word1, String word2){
        int n=word1.length();
        int m=word2.length();
        int memo[][]=new int [n][m];
        for(int a[]:memo){
            Arrays.fill(a,-1);
        }
        return lcs(word1,word2,n-1,m-1,memo);
    }
    int lcs(String word1, String word2,int i,int j,int memo[][]){
        if(i<0 || j<0) return 0;
        if(memo[i][j]!=-1) return memo[i][j];//avoid re-calculation for overlapping probs
        if(word1.charAt(i)==word2.charAt(j)){
            memo[i][j]=1+lcs(word1,word2,i-1,j-1,memo);//match
        }
        else{
            memo[i][j]=Math.max(lcs(word1,word2,i-1,j,memo),lcs(word1,word2,i,j-1,memo));
        }
        return memo[i][j];
    }
}