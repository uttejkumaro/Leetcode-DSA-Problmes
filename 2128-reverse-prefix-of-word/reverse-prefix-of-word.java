class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == ch) {
                return c + sb.reverse().toString() + word.substring(i + 1);
            }
			sb.append(c);
        }
        return word;
    }
}