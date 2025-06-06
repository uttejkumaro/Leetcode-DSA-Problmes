class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] pre = new int[n + 1];

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                pre[shift[0]]++;
                pre[shift[1] + 1]--;
            } else {
                pre[shift[0]]--;
                pre[shift[1] + 1]++;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            pre[i] += pre[i - 1];
        }
 
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = pre[i] % 26;
            if (count < 0)
                count += 26;

            char curr = (char) ((s.charAt(i) - 'a' + count) % 26 + 'a');
            res.append(curr);
        }

        return res.toString();
    }
}
