/*  time limit exceed
class Solution {
    public int[] sortArray(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
            if(nums[j]>nums[j+1]){
                int  temp=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=temp;
            }
            }
        }
        return nums;
    }
}


// quick sort
class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
    void  quicksort(int nums[],int low,int high){
        if(low<high){
            int p=partition(nums,low,high);
            quicksort(nums,low,p-1);
            quicksort(nums,p,high);
        }
    }
    int partition(int nums[],int low,int high){
        int pivot=nums[high];
        int i=low-1;
       for(int j=low;j<high;j++){
            if(nums[j]<=pivot){
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
          
       }
         int temp=nums[i+1];
            nums[i+1]=nums[high];
            nums[high]=temp;
            return i+1;
    }
}
*/
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = nums[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = nums[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }
}
