class Solution {
    public int totalWaviness(int num1, int num2) {
        int res = 0;

        while (num1 <= num2) {
            res += checkPeak(num1);
            res += checkValley(num1);
            num1++;
        }

        return res;
    }

    int checkPeak(int num) {
        int count = 0;
        String s = String.valueOf(num);
        int length = s.length();

        if (length < 3) return 0;

        for (int i = 1; i < length - 1; i++) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';

            if (curr > prev && curr > next) {
                count++;
            }
        }

        return count;
    }

    int checkValley(int num) {
        int count = 0;
        String s = String.valueOf(num);
        int length = s.length();

        if (length < 3) return 0;

        for (int i = 1; i < length - 1; i++) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';

            if (curr < prev && curr < next) {
                count++;
            }
        }

        return count;
    }

    int length(int num) {
        if (num == 0) return 1;
        return (int) (Math.log10(num)) + 1;
    }
}