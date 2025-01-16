// class Solution {
//     public int xorAllNums(int[] nums1, int[] nums2) {
//         int k=0;
//         int res[]=new int[nums1.length*nums2.length];
//         for(int i=0;i<nums1.length;i++){
//             for(int j=0;j<nums2.length;j++){
//                 res[k++]=nums1[i]^nums2[j];
//             }
//         }
//        // int max=res[0];
//        int xor=res[0];
//         for(int i=1;i<res.length;i++){
//            xor^=res[i];
//         }
//         return xor;

       
//     }
// }
 class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1=0,xor2=0;
        for(int i:nums1) xor1^=i;
        for(int i:nums2) xor2^=i;
        // int res=0;
        // if(nums1.length%2!=0) res^=xor1;
        // if(nums2.length%2!=0) res^=xor2;
        // return res;
        int n=nums1.length,m=nums2.length;
        if(n%2==1 && m%2==1) return xor1^xor2;
        else if(n%2==1) return xor2;
        else if(m%2==1) return xor1;
        return 0;
    }
 }

