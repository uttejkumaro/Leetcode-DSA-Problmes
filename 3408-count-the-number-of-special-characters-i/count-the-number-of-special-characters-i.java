class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> st = new HashSet<>();

        for (char c : word.toCharArray()) {
            st.add(c);
        }

        int count = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            if (st.contains(c) && st.contains((char)(c - 32))) {
                count++;
            }
        }

        return count;
    }
}