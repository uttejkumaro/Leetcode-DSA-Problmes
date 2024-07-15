class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals - end times
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // Initialize the end time of the first interval
        int end = intervals[0][1];
        // Count of intervals to remove
        int count = 0;

        // Start from the second interval , check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // If the current interval overlaps, increment the count
                count++;
            } else {
                // Update the end to the end of the current interval
                end = intervals[i][1];
            }
        }

        return count;
    }
}
