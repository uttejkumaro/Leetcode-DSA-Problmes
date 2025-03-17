// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         function(ans, nums, 0);
//         return ans;
//     }

//     void function(List<List<Integer>> ans, int[] arr, int start) {
//         if (start == arr.length) {
//             List<Integer> list = new ArrayList<>();
//             for (int i = 0; i < arr.length; i++) {
//                 list.add(arr[i]);
//             }
//             ans.add(list);
//             return;
//         }

//         for (int i = start; i < arr.length; i++) {
//             swap(arr, start, i);
//             function(ans, arr, start + 1);
//             swap(arr, start, i);
//         }
//     }

//     void swap(int[] arr, int a, int b) {
//         int temp = arr[a];
//         arr[a] = arr[b];
//         arr[b] = temp;
//     }
// }
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        boolean used[]=new boolean[nums.length];
        function(ans, nums, curr,used);
        return ans;
    }

    void function(List<List<Integer>> ans ,int nums[],List<Integer> curr,boolean used[]){
        if(nums.length==curr.size()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
            used[i]=true;
            curr.add(nums[i]);
            function(ans,nums,curr,used);
            curr.remove(curr.size()-1);
            used[i]=false;
            }

        }

    }
}
