class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k==0 || n >= k + maxPts-1)return 1.00;
        double dp[]=new double[n+1];
        dp[0]=1.0;//probal of i score
        double WindowSum=1.0,res=0.0;
        for(int i=1;i<=n;i++){
            dp[i]=WindowSum/maxPts;
            if(i<k){
                WindowSum+=dp[i];
            }
            else {
                res+=dp[i];
            }
            if(i-maxPts>=0){
                WindowSum-=dp[i-maxPts];
            }
        }
        return res;
    }
}