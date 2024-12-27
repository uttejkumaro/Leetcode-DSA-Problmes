class Solution {
    public int minimumOperations(int[] nums) {
        int count[] =new int[100+1];
        int lastSeen=0;
        for(int i=nums.length-1;i>=0;i--){
            if(count[nums[i]]>0){
                lastSeen=i+1;
                break;
            }
            count[nums[i]]++;
        }
        return (lastSeen%3==0)?lastSeen/3:lastSeen/3+1;

        
    }
}