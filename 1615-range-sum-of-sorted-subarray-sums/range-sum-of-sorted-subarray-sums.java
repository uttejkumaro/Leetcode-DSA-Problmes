class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subArray =new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                subArray.add(sum);
            }
        }
        Collections.sort(subArray);
        int  res=0;
        int mod=1000000007;
        for(int i=left-1;i<right;i++){
            res=(res+subArray.get(i))%mod;
        }
        return (int) res;
    }
}