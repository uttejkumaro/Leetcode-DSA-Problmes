class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // '*'
                minOpen--;     // treat '*' as ')'
                maxOpen++;     // treat '*' as '('
            }

            if (maxOpen < 0) return false; // too many ')'
            if (minOpen < 0) minOpen = 0;  // can't have negative open count
        }

        return minOpen == 0;
    }
}
