//O(n*2) t.c
/*
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i !=j && nums[i]==nums[j] && Math.abs(i-j)<=k){
                    return true;
                }
            }
        }
        return false;
        
    }
}*/
//sliding window
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k){
                return true;
            }
            map.put(nums[i],i);
        
        if(i>=k){
            map.remove(nums[i-k]);
            }
        }
        return false;
        
    }
}
