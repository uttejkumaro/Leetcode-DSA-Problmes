class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] a = new int[n], b = new int[n];
        int x = 1, y = 1;

        a[0] = nums[0];
        b[0] = nums[1];

        for (int i = 2; i < n; i++) {
            if (a[x - 1] > b[y - 1])
                a[x++] = nums[i];
            else
                b[y++] = nums[i];
        }

        int[] res = new int[n];

        for (int i = 0; i < x; i++)
            res[i] = a[i];

        for (int i = 0; i < y; i++)
            res[x + i] = b[i];

        return res;
    }
}