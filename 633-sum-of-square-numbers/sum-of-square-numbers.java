class Solution{
public boolean judgeSquareSum(int c) {
    int sqrtC = (int)Math.sqrt(c);
    for (int i = 0; i <= sqrtC; i++) {
        int j = (int)Math.sqrt(c - i * i);
        if (i * i + j * j == c) {
            return true;
        }
    }
    return false;
}
}