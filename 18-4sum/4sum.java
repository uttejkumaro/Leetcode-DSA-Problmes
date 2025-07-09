// //t.c O(n^k-1)
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int k=4;
//         Arrays.sort(nums);
//         return helper( nums,(long) target, k,0);
//     }
//     List<List<Integer>> helper(int[] nums, long target,int k,int start){
//         List<List<Integer>>res=new ArrayList<>();
//         int n=nums.length;
//         if(start==n) return res;
//         //2 sum
//         if(k==2){
//             int left=start,right=n-1;
//             while(left<right){
//                 long sum=(long)nums[left]+nums[right];
//                 if(sum==target) {

//                 res.add(Arrays.asList(nums[left],nums[right]));
//                 //avoid dupli
//                 while(left<right && nums[left]==nums[left+1])left++;
//                 while(left<right && nums[right]==nums[right-1])right--;
//                 left++;
//                 right--;
//                 }
//                 else if(sum<target) left++;
//                 else right--;
//             }
//         }
//         else{
//             for(int i=start;i<n-k+1;i++){
//                 if(i>start && nums[i]==nums[i-1]) continue;
//                 List<List<Integer>> subRes = helper(nums, target - nums[i], k - 1, i + 1);
//                 for (List<Integer> subset : subRes) {
//                 List<Integer> temp = new ArrayList<>();
//                 temp.add(nums[i]);
//                 temp.addAll(subset);
//                 res.add(temp);
//                     }
//             }
//         }
//         return res;
//      }
// }
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0&& nums[i]==nums[i-1])continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1&&  nums[j]==nums[j-1])continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                   //long sum=nums[i];
                   long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                   if(sum==target){
                    ArrayList<Integer> ans=new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[l]);
                    ans.add(nums[k]);
                    res.add(ans);
                     
                   k++;
                   l--;
                   while(k<l&& nums[k]==nums[k-1]) k++;
                   while(k<l&& nums[l]==nums[l+1]) l--;
                   }
                   else if(sum<target)k++;
                   else l--;
                }
            }
        }
                return res;
    }
}