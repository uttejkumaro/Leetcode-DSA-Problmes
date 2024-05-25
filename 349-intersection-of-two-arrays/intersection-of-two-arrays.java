import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        // Add elements of nums1 to set
        for (int num : nums1) {
            set.add(num);
        }

        // Check intersection with nums2 and store in intersectionSet
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }

        // Convert intersectionSet to array
        int[] intersectionArray = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersectionArray[index++] = num;
        }

        return intersectionArray;
    }
}

