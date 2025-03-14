class Solution {

    private void helper(int index, String digits, int n, String[] store, StringBuilder path, List<String> result) {
        if (index == n) {
            if (path.toString().length() > 0)
                result.add(path.toString());
            return;
        }
        char currentChar = digits.charAt(index);
        int currentDigit = currentChar - '0';

        for (char ch: store[currentDigit].toCharArray()) {
            path.append(ch);
            helper(index + 1, digits, n, store, path, result);
            path.deleteCharAt(path.length() - 1);
        }
        
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        
        String[] store = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        helper(0, digits, digits.length(), store, path, result);
        return result;
    }
}