class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();//result array
        generateSubsets(0,nums,new ArrayList<>(),res);//helper function
        return res;        
    }
    void  generateSubsets(int index,int nums[],List<Integer>current,List<List<Integer>>res){
        if (index==nums.length){
            res.add(new ArrayList<>(current));
            return ;
        }
         // Exclude the current element
        generateSubsets(index + 1, nums, current, res);
        
        // Include the current element
        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, res);
        
        // Backtrack
        current.remove(current.size() - 1);

    }

}