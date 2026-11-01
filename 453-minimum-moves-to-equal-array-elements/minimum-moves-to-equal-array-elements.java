//increment n-1 elements is same as decrement of 1 element
//moves=sum of ele-min
class Solution {
    public int minMoves(int[] nums) {
        int min=min(nums);
        int sum=0;
        for(int i:nums)sum+=i-min;
        return sum;
    }
    int min(int nums[]){
        int min=Integer.MAX_VALUE;
        for(int i:nums)min=Math.min(i,min);
        return min;
    }
}