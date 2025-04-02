// class Solution {
//     public long maximumTripletValue(int[] nums) {
//         int n=nums.length;
//         long max=0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 for(int k=j+1;k<n;k++){
//                     max=Math.max(max,(long)(nums[i]-nums[j])*nums[k]);

//                 }
//             }
//         }
//         return max;
//     }
// }
class Solution {
    public long maximumTripletValue(int[] nums) {

        int n=nums.length;
        if(n<3) return 0 ;
        long max=0;
        int suffix[]=new int[n];
        int prefix[]=new int[n];
        prefix[0]=nums[0];
        suffix[n-1]=nums[n-1];
        for(int i=1;i<n;i++) prefix[i]=Math.max(nums[i],prefix[i-1]);
        for(int i=n-2;i>=0;i--) suffix[i]=Math.max(nums[i],suffix[i+1]);
        for(int i=1;i<n-1;i++){
            max=Math.max((long)(prefix[i-1]-nums[i])*suffix[i+1],max);
        }
    return max;
    }
}