class Solution {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (result.length() > 0 && Math.abs(result.charAt(result.length() - 1) - c) == 32) {
                result.deleteCharAt(result.length() - 1); // Remove the last character from result
            } else {
                result.append(c); // Append the character to result
            }
        }
        return result.toString();
    }
}
