class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] memo = new int[n + 1][m + 1];        
        // Fill the memo table using LCS logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        // Reconstruct the shortest common supersequence from the memo 
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));  // If chars match, take from both
                i--;
                j--;
            } else if (memo[i - 1][j] > memo[i][j - 1]) {
                sb.append(str1.charAt(i - 1));  // Take from str1
                i--;
            } else {
                sb.append(str2.charAt(j - 1));  // Take from str2
                j--;
            }
        }        
        // Add the rem characters of str1 and str2
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }
        
        return sb.reverse().toString();  // Reverse the result string as we've built it backwards
    }
}
