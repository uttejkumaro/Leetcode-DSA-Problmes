class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxNumber = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (maxNumber < count)
                    maxNumber = count;
            } else if (c == ')') {
                count--;
            }
        }
        return maxNumber;
    }
}