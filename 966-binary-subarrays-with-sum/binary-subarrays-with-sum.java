class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer>sum=new HashMap<>();
        sum.put(0,1);//0 sum -count1
        int s=0;
        int count=0;
        for(int n:nums){
            s+=n;
            if(sum.containsKey(s-goal)){
                count+=sum.get(s-goal);
            }
            sum.put(s,sum.getOrDefault(s,0)+1);
        }
        return count;        
        
    }
}