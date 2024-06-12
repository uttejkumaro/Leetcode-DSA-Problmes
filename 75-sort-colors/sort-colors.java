/* time complexity:O(nlogn)
 space  complexity:O(1)
inplace,stable:y,y
class Solution {
    public int[] sortColors(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
*/
//dutch national flag  algorithm
//O(n),O(1)
class Solution{
      public void  sortColors(int[] nums) {
        int low=0;int mid=0;int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                //swap nums[low],nums[mid],increment low & mid
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }

        }








      }





}

