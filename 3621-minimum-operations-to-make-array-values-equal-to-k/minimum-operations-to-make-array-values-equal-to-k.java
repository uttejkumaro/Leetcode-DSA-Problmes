class Solution {
    public int minOperations(int[] nums, int k) {
        for(int i:nums){
            if(i<k) return -1;
        }
       // Arrays.sort(nums);
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        if(nums.length==1 && k==nums[0]){
            return 0;
        }
        if(nums.length==1){
            return (nums[0]>k)?1:-1;
        }
        
        int count=0;
        for(int i:set){
            if(i==k){
                count++;
            }
        }
        return (count>0)?set.size()-1:set.size();
        
    }
}
//class Solution {
//     public int minOperations(int[] nums, int k){
//         Arrays.sort(nums);
//         if(nums[0]<k) return -1;
//         Set<Integer> st=new HashSet<>();
//         for(int i:nums) st.add(i);
//         st.remove(k);
//         return st.size();
//     }
// }