/*
public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
*/
public class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0; i<32; i++){
            ans |=(n & 1) << (31 - i);
            n >>= 1;
        }
        return ans;
    }
}

