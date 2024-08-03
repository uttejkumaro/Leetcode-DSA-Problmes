class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combi = new ArrayList<>();
        if (digits.length() == 0) return combi;        
        String[] map = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        backtrack(0, new StringBuilder(), digits, map, combi);
        return combi;
    }
    
    void backtrack(int index, StringBuilder path, String digits, String[] letters, List<String> combi) {
        if (path.length() == digits.length()) {
            combi.add(path.toString());
            return;
        }
        String possLetters = letters[digits.charAt(index) - '0'];
        if (possLetters != null) {
            for (int i = 0; i < possLetters.length(); i++) {
                path.append(possLetters.charAt(i)); // Append one character at a time
                backtrack(index + 1, path, digits, letters, combi);
                path.deleteCharAt(path.length() - 1); // Remove the last character
            }
        }
    }
}
