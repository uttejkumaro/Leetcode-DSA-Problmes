class Solution {
    public List<List<Integer>> combinationSum(int[] candiates, int target) {
        List<List<Integer>> res=new ArrayList<>();  
        backtrack(candiates,target,0,new ArrayList<>(),res);
        return res;        
    }
    void backtrack(int []candiates,int target,int start,List<Integer> 
    combination,List<List<Integer>> res){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(combination));
            return ;
        }
        // for(int i=start;i<candiates.length;i++){
        //     combination.add(candiates[i]);
        //     backtrack(candiates,target-candiates[i],i,combination,res);
        //     combination.remove(combination.size()-1);
        // }
        if(start<candiates.length){

       combination.add(candiates[start]);
            backtrack(candiates,target-candiates[start],start,combination,res);
            combination.remove(combination.size()-1);
            backtrack(candiates,target,start+1,combination,res);
        }
     
    }
}