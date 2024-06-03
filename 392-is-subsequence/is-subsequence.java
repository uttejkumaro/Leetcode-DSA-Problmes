class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;
        int sLength = s.length(), tLength = t.length();

        // Iterate through t using tPointer
        while (tPointer < tLength) {
            // If characters match, move sPointer to the next character in s
            if (sPointer < sLength && s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            // Move tPointer to the next character in t
            tPointer++;
        }

          return sPointer == sLength;
    }
}
