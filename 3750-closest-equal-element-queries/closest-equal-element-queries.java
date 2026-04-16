// import java.util.*;

// class Solution {
//     public List<Integer> solveQueries(int[] nums, int[] queries) {
//         int n = nums.length;
//         List<Integer> res = new ArrayList<>();

//         for (int i = 0; i < queries.length; i++) {
//             int q = queries[i];
//             int target = nums[q];

//             int minDist = Integer.MAX_VALUE;

//             for (int j = 0; j < n; j++) {
//                 if (j == q) continue;

//                 if (nums[j] == target) {
//                     int d = Math.abs(j - q);
//                     int circularDist = Math.min(d, n - d);
//                     minDist = Math.min(minDist, circularDist);
//                 }
//             }

//             if (minDist == Integer.MAX_VALUE) res.add(-1);
//             else res.add(minDist);
//         }

//         return res;
//     }
// }
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // value -> sorted list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();

        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            // only one occurrence
            if (list.size() == 1) {
                res.add(-1);
                continue;
            }

            // binary search to find position of q
            int pos = Collections.binarySearch(list, q);

            int size = list.size();

            // next index (circular)
            int next = list.get((pos + 1) % size);

            // previous index (circular)
            int prev = list.get((pos - 1 + size) % size);

            // compute circular distances
            int d1 = Math.abs(next - q);
            d1 = Math.min(d1, n - d1);

            int d2 = Math.abs(prev - q);
            d2 = Math.min(d2, n - d2);

            res.add(Math.min(d1, d2));
        }

        return res;
    }
}