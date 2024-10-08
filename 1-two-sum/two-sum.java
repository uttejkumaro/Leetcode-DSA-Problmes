//  time complexity:O(n2)
// space :O(1)
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
// */
/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        // Find the complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }
}

*/
//we will build hashtable after checking andbefore code we will build hash tabel and then we will check
//time complexity:O(n), space complexity:O(1)
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n=nums.length;
//         Map<Integer,Integer>map=new HashMap<>();
//       for(int i=0;i<n;i++){
//         int complement=target-nums[i];
//         if(map.containsKey(complement)){
//             return new int []{map.get(complement),i};
//         }
//         //else
//         map.put(nums[i],i);
//       }
//       return null;


//     }
// }