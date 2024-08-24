class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);

        // Special cases for very small n
        if (num <= 10 || (num == Math.pow(10, len - 1))) {
            return String.valueOf(num - 1);
        }
        if (num == 11) {
            return "9";
        }

        // Candidates set to hold possible palindrome values
        HashSet<Long> candidates = new HashSet<>();

        // Edge cases for numbers like 1000...0001 and 999...999
        candidates.add((long)Math.pow(10, len) + 1);  // 1000...0001
        candidates.add((long)Math.pow(10, len - 1) - 1);  // 999...999

        // Create a candidate by mirroring the first half
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        for (long i = -1; i <= 1; i++) {
            String strPrefix = String.valueOf(prefix + i);
            StringBuilder candidate = new StringBuilder(strPrefix);

            // If the length of n is even, mirror the entire strPrefix
            // If odd, omit the last digit of strPrefix
            String palin = candidate.append(new StringBuilder(strPrefix.substring(0, len / 2)).reverse().toString()).toString();
            candidates.add(Long.parseLong(palin));
        }

        // Remove the original number from the candidates set
        candidates.remove(num);

        // Find the closest palindrome
        long minDiff = Long.MAX_VALUE;
        long closestPalin = 0;

        for (long candidate : candidates) {
            long diff = Math.abs(candidate - num);
            if (diff < minDiff || (diff == minDiff && candidate < closestPalin)) {
                minDiff = diff;
                closestPalin = candidate;
            }
        }

        return String.valueOf(closestPalin);
    }
}