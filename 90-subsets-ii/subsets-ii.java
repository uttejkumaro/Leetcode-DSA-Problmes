// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//          List<List<Integer>>res=new ArrayList<List<Integer>>();
//          ArrayList<Integer>combi=new ArrayList<>();
//          Arrays.sort(nums);
//          gensuper(nums,0,combi,res);
//          return res;

//     }
//     void gensuper(int nums[],int idx,ArrayList<Integer>combi,List<List<Integer>>res){
//        res.add(new ArrayList<>(combi));
//        for(int i=idx;i<nums.length;i++){
//         if( i>idx && nums[i]==nums[i-1]) continue;
//             combi.add(nums[i]);
//             gensuper(nums,i+1,combi,res);            
//             combi.remove(combi.size()-1);
//        }
//     }

// }

 
class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> res=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, list,res);
        return list;
    }

    public void backtrack(int[] nums, int index,List<List<Integer>> list ,List<Integer> res) {
        if (index == nums.length) {
            if(!list.contains(res)){
            list.add(new ArrayList(res));
            }
        } else {
            res.add(nums[index]);
            backtrack(nums, index + 1,list, res);
            res.remove(res.size() - 1);
            backtrack(nums, index + 1,list,res);

        }
    }
}