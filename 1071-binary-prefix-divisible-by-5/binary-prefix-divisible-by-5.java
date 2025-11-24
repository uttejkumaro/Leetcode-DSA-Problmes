class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
         List<Boolean>result=new ArrayList<>();
        //  Arrays.fill(result,true);
        long  ans=0;
           for (int bit : nums) {
             ans = (ans * 2 + bit) % 5;
            result.add(ans == 0);
         }
         return result;
         
    }
}