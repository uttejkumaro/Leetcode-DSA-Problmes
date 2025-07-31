class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        int max=-1;
        for(int i:mp.values()){
            max=Math.max(max,i);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(mp.get(nums[i])==max)count++;
        }
        return count;
    }
}