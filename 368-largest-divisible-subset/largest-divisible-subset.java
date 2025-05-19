class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer>res=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        if (n == 0) return res;
        int[] dp = new int[n];    // dp[i] = length of largest divisible subset ending at i
        int[] prev = new int[n];     // prev[i] = index of previous element in subset
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);
        int maxLen=1;
        int lastIdx=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                        dp[i]=1+dp[j];
                        prev[i]=j;
                }
            }
            if(dp[i]>maxLen){
                maxLen=dp[i];
                lastIdx=i;
            }
        } 
        while(lastIdx!=-1){
            res.add(nums[lastIdx]);
            lastIdx=prev[lastIdx];
        }
        Collections.reverse(res);
        return res;
    }
}