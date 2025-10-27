class Solution {
    int countOfOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }

    public int numberOfBeams(String[] bank) {
        int prev = 0, ans = 0;
        for (String row : bank) {
            int curr = countOfOnes(row);
            if (curr > 0) {
                ans += prev * curr;
                prev = curr;
            }
        }
        return ans;
    }
}
