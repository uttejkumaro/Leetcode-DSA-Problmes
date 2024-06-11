import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Step 1: Count occurrences of each element in arr1
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr1) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        // Step 2: Initialize the result array and index pointer
        int[] res = new int[arr1.length];
        int idx = 0;

        // Step 3: Sort based on the order in arr2
        for (int i : arr2) {
            if (countMap.containsKey(i)) {
                int count = countMap.get(i);
                for (int j = 0; j < count; j++) {
                    res[idx++] = i;
                }
                countMap.remove(i);
            }
        }

        // Step 4: Collect remaining elements not in arr2 and sort them
        List<Integer> rem = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            for (int j = 0; j < count; j++) {
                rem.add(entry.getKey());
            }
        }
        Collections.sort(rem);

        // Step 5: Add the sorted remaining elements to the result array
        for (int i : rem) {
            res[idx++] = i;
        }

        return res;
    }
}
