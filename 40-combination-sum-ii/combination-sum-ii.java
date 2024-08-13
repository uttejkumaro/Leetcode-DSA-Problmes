//duplicates aren't allowed
class Solution {
    private void backtrack( List<List<Integer>>res,List<Integer> temp,int candidates[],int remain,int start){
        if(remain<0)return;
        else if(remain==0)res.add(new ArrayList<>(temp));
        else{
            for(int i=start;i<candidates.length;i++){
                if(i>start && candidates[i]==candidates[i-1]){
                    continue;//skip curr itr to skip dupli
                }
                temp.add(candidates[i]);
                backtrack(res,temp,candidates,remain-candidates[i],i+1);
                temp.remove(temp.size()-1);

            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>>res=new  ArrayList<>();
         Arrays.sort(candidates);
         backtrack(res,new ArrayList<>(),candidates,target,0);
         return res;
    }
}