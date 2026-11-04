
import java.util.*;

class Solution {

    class MedianWindow {

        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        long sumLow = 0, sumHigh = 0;
        int lowSize = 0, highSize = 0;
        int target;

        MedianWindow(int x) {
            target = (x + 1) / 2;
        }

        void insert(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void delete(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        void rebalance() {

            while (lowSize > target) {
                int val = low.lastKey();

                delete(low, val);
                lowSize--;
                sumLow -= val;

                insert(high, val);
                highSize++;
                sumHigh += val;
            }

            while (lowSize < target && highSize > 0) {
                int val = high.firstKey();

                delete(high, val);
                highSize--;
                sumHigh -= val;

                insert(low, val);
                lowSize++;
                sumLow += val;
            }
        }

        void add(int val) {

            if (low.isEmpty() || val <= low.lastKey()) {
                insert(low, val);
                lowSize++;
                sumLow += val;
            } else {
                insert(high, val);
                highSize++;
                sumHigh += val;
            }

            rebalance();
        }

        void remove(int val) {

            if (low.containsKey(val)) {
                delete(low, val);
                lowSize--;
                sumLow -= val;
            } else {
                delete(high, val);
                highSize--;
                sumHigh -= val;
            }

            rebalance();
        }

        long getCost() {
            long median = low.lastKey();

            return median * lowSize - sumLow
                 + sumHigh - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate cost of every window.
        long[] cost = new long[n - x + 1];

        MedianWindow window = new MedianWindow(x);

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

        for (int i = x; i < n; i++) {
            window.remove(nums[i - x]);
            window.add(nums[i]);

            cost[i - x + 1] = window.getCost();
        }

        // Step 2: DP for k non-overlapping windows.
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Option 1: Skip current element.
                curr[i] = curr[i - 1];

                // Option 2: Select a window of size x.
                if (i >= x && prev[i - x] != INF) {

                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
