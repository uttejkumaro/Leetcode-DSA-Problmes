class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int n=nums.length;
        int max=-1;
        for(int i=0;i<n;i++){
           max=Math.max(max,mp.getOrDefault(nums[i],0)+1);
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        // for(int i:mp.values()){
        //     max=Math.max(max,i);
        // }
        int count=0;
        for(int i=0;i<n;i++){
            if(mp.get(nums[i])==max)count++;
        }
        return count;
    }
}