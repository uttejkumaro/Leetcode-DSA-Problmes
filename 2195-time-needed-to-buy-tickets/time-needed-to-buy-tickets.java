public class Solution {
    public int timeRequiredToBuy(int[] v, int k) {
        int n = v.length;
        int total = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (v[i] > 0) {
                    v[i] = v[i] - 1;
                    total++;
                }
                if (i == k && v[i] == 0)
                    return total;
            }
        }
    }
}