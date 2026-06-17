class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long[] len = new long[n];
        long cur = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                cur++;
            } else if (c == '*') {
                if (cur > 0) cur--;
            } else if (c == '#') {
                cur = Math.min(cur * 2, (long) 1e18);
            } else { // %
                // length unchanged
            }

            len[i] = cur;
        }

        if (k >= cur) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            long before = (i == 0) ? 0 : len[i - 1];

            if (c >= 'a' && c <= 'z') {
                if (k == before) return c;
            }
            else if (c == '#') {
                if (before > 0 && k >= before) {
                    k -= before;
                }
            }
            else if (c == '%') {
                if (before > 0) {
                    k = before - 1 - k;
                }
            }
        }

        return '.';
    }
}