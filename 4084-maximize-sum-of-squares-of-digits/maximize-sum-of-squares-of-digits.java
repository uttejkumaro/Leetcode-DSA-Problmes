
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder s = new StringBuilder();
        if(num*9<sum)return "";
        while (num > 0) {
            if (sum >= 9) {
                s.append('9');
                sum -= 9;
            } else {
                s.append(sum);
                sum = 0;
            }
            num--;
        }
        

        return s.toString();
    }
}
