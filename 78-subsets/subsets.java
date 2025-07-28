class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        helper(res,0,curr,nums);   

        return res;     
    }
    void helper(List<List<Integer>>res,int i,List<Integer>curr,int nums[]){
        if(i==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(res,i+1,curr,nums);
        curr.remove(curr.size()-1);
        helper(res,i+1,curr,nums);
    }
}
/**
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n;  // 2^n subsets
        List<List<Integer>> result = new ArrayList<>();

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        return result;
    }
}
 */