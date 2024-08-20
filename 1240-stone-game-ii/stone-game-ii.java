//dp
class Solution {
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int dp[][]=new int[n][n];
        int suffix[]=new int[n];//suffixsum
        suffix[n-1]=piles[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]+piles[i];
              
        }
        return stoneGameII(piles,dp,suffix,0,1);   
    }
        int stoneGameII(int piles[],int dp[][],int suffix[],int i,int M){
            if(i>=piles.length) return 0;
            if(2*M>=piles.length-i){
                return suffix[i];

            }
            if(dp[i][M]>0) return dp[i][M];
            int maxStones=0;
            for(int x=1;x<=2*M;x++){
                 maxStones = Math.max(maxStones,suffix[i]-stoneGameII(piles,dp,suffix,i+x, Math.max(M,x)));

            }
            dp[i][M]=maxStones;
            return maxStones;
        }     
        
    }
    