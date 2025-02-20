class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<String>res=new ArrayList<>();
        int n=nums.length;
        generate("",n,res);
        res.removeAll(Arrays.asList(nums));
        return res.get(0);
        
    }
    void generate(String curr,int n,List<String>res){
        if(curr.length()==n){
            res.add(curr);
            return ;
        }
        generate(curr+"0",n,res);
        generate(curr+"1",n,res);
    }
}