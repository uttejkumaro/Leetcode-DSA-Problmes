class Solution {
    public int maxJump(int[] stones) {
        int n=stones.length;
        int dp[]=new int[n];
        dp[0]=0;
        int max=0;
        for(int i=0;i+2<n;i++){
            max=Math.max(max,Math.abs(stones[i+2]-stones[i]));
        }
        max=Math.max(max,Math.abs(stones[0]-stones[1]));
        max=Math.max(max,Math.abs(stones[n-2]-stones[n-1]));
        return max;
        
    }
}