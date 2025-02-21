
//t.c:O(nlogn)
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length/2];//middle element is the element which is present more than n/2
        
//     }
// }
//Boyer-Moore Voting Algorithm:

// class Solution{
//     public int  majorityElement(int[] nums) {
//         int n=nums.length;
//         int c=0;
//         int v=0;
//         for(int num:nums){
//             if(c==0) v=num;
//             c+=(v==num)?1:-1;

            
//         }
//         c=0;
//         for(int num:nums){
//             if(v==num) c++;
//         }
//         return (c>=n/2)?v:-1;
//     }

// }
class Solution{
    public int  majorityElement(int[] nums) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);

        }
        for(Map.Entry<Integer,Integer>e:mp.entrySet()){
            if(e.getValue()>nums.length/2){
                return e.getKey();
            }
        }
        return -1;
    }
}