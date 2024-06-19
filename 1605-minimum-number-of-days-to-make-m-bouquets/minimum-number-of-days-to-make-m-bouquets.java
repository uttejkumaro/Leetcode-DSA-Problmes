class Solution {
    public boolean check(int[] bloomDay, int mid, int m, int k) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                total += count / k;
                count = 0;
            }
        }
        total += count / k;
        return total >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
    
          if (bloomDay.length < (long) m*k)
            return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int val : bloomDay) {
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        int start = min, end = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(bloomDay, mid, m, k)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}