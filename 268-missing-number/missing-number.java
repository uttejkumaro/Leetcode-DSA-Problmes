/* class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer>numset=new HashSet<Integer>();
        for(int num:nums){
            numset.add(num);
        }
        int expect_count=nums.length+1;
        for(int n=0;n<expect_count;n++){
            if(!numset.contains(n)){
                return n;
            }
        }
        return -1;

        
    }
} */
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length-1;
        int actSum=(n+1)*(n+2)/2;
        int sum=0;
        for(int i:nums){
            sum=sum+i;
        }
        return actSum-sum;
    }
}