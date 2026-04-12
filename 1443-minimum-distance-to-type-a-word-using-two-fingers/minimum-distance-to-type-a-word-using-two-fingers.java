import java.util.*;

class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[26][26];

        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        int first = word.charAt(0) - 'A';

        for (int j = 0; j < 26; j++) {
            dp[first][j] = 0;
            dp[j][first] = 0;
        }

        for (int k = 1; k < n; k++) {
            int curr = word.charAt(k) - 'A';
            int[][] newDp = new int[26][26];

            for (int[] row : newDp)
                Arrays.fill(row, Integer.MAX_VALUE);

            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dp[i][j] == Integer.MAX_VALUE)
                        continue;

                    int cost = dp[i][j];

                    newDp[curr][j] = Math.min(newDp[curr][j], cost + dist(i, curr));
                    newDp[i][curr] = Math.min(newDp[i][curr], cost + dist(j, curr));
                }
            }

            dp = newDp;
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                res = Math.min(res, dp[i][j]);
            }
        }

        return res;
    }

    int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}