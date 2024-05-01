class Solution {
    public String reversePrefix(String word, char ch) {
        int to = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                to = i;
                break;
            }
        }
        if (to == -1) return word;

        StringBuilder sb = new StringBuilder();
        for (int i = to; i >= 0; i--) sb.append(word.charAt(i));
                
        for (int i = to+1; i < word.length(); i++) sb.append(word.charAt(i));
        return sb.toString();
    }
}