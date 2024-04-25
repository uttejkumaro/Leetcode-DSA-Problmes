class Solution {
    
    public int longestIdealString(String s, int k) {
      int[] dp=new int[26];     
      for(int i=s.length()-1;i>=0;i--){
        int current =s.charAt(i)-'a';
        int start=Math.max(current-k,0);
        int end =Math.min(current+k,25);
        int currentMax=0;
        for(int j=start;j<=end;j++){
             currentMax=(int)Math.max(currentMax,dp[j]);
        }
        dp[current]=currentMax+1;
      }
      int max=1;
     for(int a:dp)
     max=Math.max(max,a);
     return max;
    }
    
    
}