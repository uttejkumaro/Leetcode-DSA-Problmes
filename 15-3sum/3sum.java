class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicates for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Use two pointers to find the other two elements
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Avoid duplicates for the second element of the triplet
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Avoid duplicates for the third element of the triplet
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move pointers after finding a valid triplet
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}

//     Set<List<Integer>> set = new HashSet<>();
//     int n = nums.length;

//     for (int i = 0; i < n - 2; i++) {
//         for (int j = i + 1; j < n - 1; j++) {
//             for (int k = j + 1; k < n; k++) {
//                 if (nums[i] + nums[j] + nums[k] == 0) {
//                     List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
//                     Collections.sort(triplet);
//                     set.add(triplet);
//                 }
//             }
//         }
//     }

//     return new ArrayList<>(set);
// }
// }