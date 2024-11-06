// class Solution {
//     int countSetBits(int i){
//         String s=Integer.toBinaryString(i);
//         char c[]=s.toCharArray();
//         int set=0;
//         for(int j=0;j<c.length;j++){
//             if(c[j]=='1'){
//                 set++;
//             }
//         }
//         return set;

//     }    
//     public boolean canSortArray(int[] nums) {
//          Map<Integer, List<Integer>> setBitGroups = new HashMap<>();
//           for (int num : nums) {
//             int setBits = countSetBits(num);
//             setBitGroups.putIfAbsent(setBits, new ArrayList<>());
//             setBitGroups.get(setBits).add(num);
//         }
//         for (List<Integer> group : setBitGroups.values()) {
//             List<Integer> sortedGroup = new ArrayList<>(group);
//             Collections.sort(sortedGroup);
//             if (!group.equals(sortedGroup)) {
//                 return false; 
//             }
//         }
//         return true;      
        
//     }
// }
class Solution {    
    void swap(int [] nums, int leftIndex, int rightIndex) {
        int temp = nums[leftIndex];
        nums[leftIndex] = nums[rightIndex];
        nums[rightIndex] = temp;
    }
    public boolean canSortArray(int[] nums) {    
        int n = nums.length;        
        for(int i = 1; i < n; i++) {
            if(nums[i] >= nums[i-1]) continue;
            else {
                if(Integer.bitCount(nums[i]) == Integer.bitCount(nums[i-1])) 
                    swap(nums, i, i - 1);
                else return false;
            }
        }
        for(int i = n - 1; i >= 1 ;i--) {
            if(nums[i] >= nums[i-1]) continue;
            else {
                if(Integer.bitCount(nums[i]) == Integer.bitCount(nums[i-1])) 
                    swap(nums, i, i - 1);
                else return false;
            }
        }
        return true;
    }
}