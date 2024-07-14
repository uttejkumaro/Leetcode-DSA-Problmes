import java.util.TreeMap;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false; // not possible to divide
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {
            int start = map.firstKey(); // get the smallest key
            for (int i = start; i < start + k; i++) {
                if (!map.containsKey(i)) {
                    return false; // sequence is broken
                }
                int count = map.get(i);
                if (count == 1) {
                    map.remove(i);
                } else {
                    map.put(i, count - 1);
                }
            }
        }

        return true;
    }
/* 
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 3, 4, 4, 5, 6};
        int k1 = 4;
        System.out.println(solution.isPossibleDivide(nums1, k1)); // true

        int[] nums2 = {3, 3, 2, 2, 1, 1};
        int k2 = 3;
        System.out.println(solution.isPossibleDivide(nums2, k2)); // true

        int[] nums3 = {1, 2, 3, 4};
        int k3 = 3;
        System.out.println(solution.isPossibleDivide(nums3, k3)); // false
    }
    */
}
