class Solution {

    static class Pair {
        long cnt, wavy;

        Pair(long cnt, long wavy) {
            this.cnt = cnt;
            this.wavy = wavy;
        }
    }

    private char[] digits;
    private Pair[][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 0) return 0;

        digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        memo = new Pair[len + 1][3][11][11][2];

        return dfs(0, 0, 10, 10, 1).wavy;
    }

    private Pair dfs(int pos, int state, int prev2, int prev1, int tight) {
        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (tight == 0 && memo[pos][state][prev2][prev1][0] != null) {
            return memo[pos][state][prev2][prev1][0];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;

        long totalCnt = 0;
        long totalWavy = 0;

        for (int d = 0; d <= limit; d++) {
            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (state == 0) {
                if (d == 0) {
                    Pair nxt = dfs(pos + 1, 0, 10, 10, ntight);
                    totalCnt += nxt.cnt;
                    totalWavy += nxt.wavy;
                } else {
                    Pair nxt = dfs(pos + 1, 1, 10, d, ntight);
                    totalCnt += nxt.cnt;
                    totalWavy += nxt.wavy;
                }
            } else if (state == 1) {
                Pair nxt = dfs(pos + 1, 2, prev1, d, ntight);
                totalCnt += nxt.cnt;
                totalWavy += nxt.wavy;
            } else {
                int add = ((prev1 > prev2 && prev1 > d) ||
                           (prev1 < prev2 && prev1 < d)) ? 1 : 0;

                Pair nxt = dfs(pos + 1, 2, prev1, d, ntight);

                totalCnt += nxt.cnt;
                totalWavy += nxt.wavy + (long) add * nxt.cnt;
            }
        }

        Pair res = new Pair(totalCnt, totalWavy);

        if (tight == 0) {
            memo[pos][state][prev2][prev1][0] = res;
        }

        return res;
    }
}