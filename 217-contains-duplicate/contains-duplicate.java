/* 3 approaches
1.for in for O(n^2)
2.for .sorto(nlogn),o(1)
3.hashset o(n),o(1)
*/
/*
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
         for (int i = 0; i < n; i++){
            for (int j =i+1; j < n; j++){ //o(n2),o(1)
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
          return false;
    }
    
}
*/
/*
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {//o(nlogn),o(1)
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}
*/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            if(!set.add(i)){
                return true;
            }
        }
        return false;

    }
}