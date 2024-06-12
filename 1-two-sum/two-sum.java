/*  time complexity:O(n2)
space :O(1)
class Solution{
        public int[] twoSum(int[] nums, int target) {
                for (int i=0;i<nums.length;i++){
                    for (int j=i+1;j<nums.length;j++){
                        if (nums[i]+nums[j]==target){
                            return new int []{i,j};
                        }
                    }
                }
                return new int []{};


        }

}
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
      for(int i=0;i<n;i++){
        int complement=target-nums[i];
        if(map.containsKey(complement)){
            return new int []{map.get(complement),i};
        }
        //else
        map.put(nums[i],i);
      }
      return null;


    }
}