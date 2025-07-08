// class Solution {
//     public int minimumDifference(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
        
//         int sum=0;
//         int n=nums.length;
//         for(int i :nums) sum+=i;
//         if(sum<=0) return (int)1e9;
//         int target=sum/2;
//         boolean dp[][]=new boolean[n][target+1];
//         for(int i=0;i<n;i++){
//             dp[i][0]=true;
//         }
//         // if(nums[0]<=target)dp[0][nums[0]]=true;
//         if (nums[0] >= 0 && nums[0] <= target) {
//                 dp[0][nums[0]] = true;
//             }

//         for(int i=1;i<n;i++){
//             for(int j=1;j<=target;j++){
//                 boolean notTake=dp[i-1][j];
//                 boolean take=false;
//                 if(nums[i]<=j)take=dp[i-1][j-nums[i]];
//                 dp[i][j]=take||notTake;
//             }
//         }
//         //s1-s2 ===total-s2-s2====total-2*s2
//         int minDiff=(1nt)1e9;
//         for(int s1=0;s1<=target;s1++){
//             if(dp[n-1][s1]){
//                 int s2=sum-s1;
//                 minDiff=Math.min(minDiff,Math.abs(s2-s1));
//             }
//         }
//         return minDiff;

//     }
// }
class Solution {
    public int minimumDifference(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int target = totalSum / 2;
        int half = nums.length / 2;
        int best = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for (int i = 0; i <= half; i++) {
            map1.put(i, new ArrayList<>());
            map2.put(i, new ArrayList<>());
        }

        generateSubsetSums(nums, 0, half, 0, 0, map1);
        generateSubsetSums(nums, half, nums.length, 0, 0, map2);

        for (int i = 0; i <= half; i++) {
            List<Integer> list1 = map1.get(i);
            List<Integer> list2 = map2.get(half - i);

            Collections.sort(list1);
            Collections.sort(list2);

            int l = 0, r = list2.size() - 1;
            while (l < list1.size() && r >= 0) {
                int sum = list1.get(l) + list2.get(r);
                int diff = Math.abs(target - sum);

                if (diff < best) {
                    best = diff;
                    bestSum = sum;
                }

                if (sum < target) l++;
                else r--;
            }
        }

        return Math.abs(totalSum - 2 * bestSum);
    }
    private void generateSubsetSums(int[] nums, int start, int end, int sum, int count, Map<Integer, List<Integer>> map) {
        if (start == end) {
            map.get(count).add(sum);
            return;
        }
        generateSubsetSums(nums, start + 1, end, sum + nums[start], count + 1, map);
        generateSubsetSums(nums, start + 1, end, sum, count, map);
    }
}