class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = n - 1, j = m - 1;
        int k = n + m - 1;
        int[] res = new int[n + m];
        
          // Merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                res[k--] = nums1[i--];
            } else {
                res[k--] = nums2[j--];
            }
        }

        // Copy remaining elements
        while (i >= 0) {
            res[k--] = nums1[i--];
        }
        while (j >= 0) {
            res[k--] = nums2[j--];
        }
        int len=n+m;
        if((len&1)==1)return (double)res[len/2];
        else return ((double)res[len/2]+(double)res[len/2 - 1]) / 2.0;

    }
}