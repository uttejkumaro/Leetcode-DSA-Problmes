class Solution {
    private void permu(int nums[],boolean freq[], List<List<Integer>> ans,List<Integer> ds){
        if(ds.size()==nums.length){
            ans.add(new ArrayList(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                if (i>0&&nums[i]==nums[i-1]&&!freq[i-1]){
                    continue;
                }
                freq[i]=true;
                ds.add(nums[i]);
                permu(nums,freq,ans,ds);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean freq[]=new boolean[nums.length];
        Arrays.sort(nums);
        permu(nums,freq,ans,ds);
        return ans;        
    }
}