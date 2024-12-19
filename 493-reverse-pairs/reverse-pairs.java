//tle
// class Solution {
//     // void  swap(int a,int b){
//     //     int temp=a;
//     //     a=b;
//     //     b=temp;
//     // }
//     public int reversePairs(int[] nums) {
//         int n=nums.length;
//         int count=0;
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<n;j++){
//                 if((long)nums[i]>(long)nums[j]*2){
//                    count++;
//                 }
//             }
//         }
//         return count;
        
//     }
// }


class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        if(nums==null || nums.length==0) return 0;
        return mergeCountSort(nums,0,n-1,new int[n]);
    }
     int mergeCountSort(int nums[],int left,int right,int temp[]){
        if(left>=right) return 0;
        int mid=left+(right-left)/2;
        int count=mergeCountSort(nums,left,mid,temp)+mergeCountSort(nums,mid+1,right,temp);
        count+=mergeCount(nums,left,mid,right,temp);
        return count;
     }
     int mergeCount(int nums[],int left,int mid,int right,int temp[]){
        int count=0;
        int j=mid+1;
        for(int i=left;i<=mid;i++){
            while(j<=right && (long)nums[i]>2L*nums[j]){
                j++;
            }
            count+=j-mid-1;
        }
         int i = left, k = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // Copy remaining elements from both subarrays
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        // Copy the sorted subarray back to the original array
        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
        return count;
    }
}

