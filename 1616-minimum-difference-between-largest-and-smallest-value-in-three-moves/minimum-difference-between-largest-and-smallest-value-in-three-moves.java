/*
// it will not replace samlll elements it will only remove 3 larges  elemsts o it is not good sol
class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n>=5){
        int mindiff=nums[n-4]-nums[0];
        return mindiff;
        }
       return 0;
    }
}
*/
class Solution {
    public int minDifference(int[] nums) {
        int n=nums.length;
        if(n<=4){
            return 0;
        }
        Arrays.sort(nums);
         // Calculate the minimum difference by  the four possible operations:
        // 1. Remove the three largest elements
        // 2. Remove the two largest elements and the smallest element
        // 3. Remove the largest element and the two smallest elements
        // 4. Remove the three smallest elements
        int min   =Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            min=Math.min(min,nums[n+i-4]-nums[i]);
        }
        return min;
    }
}