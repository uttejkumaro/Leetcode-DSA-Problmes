class Solution {
    public int minBitFlips(int start, int goal) {
        int res=start ^goal;
        // String str=Integer.toBinaryString(res);
        // int count=0;
        // for(char c:str.toCharArray()){
        //     if(c=='1') count++;
        // }
        return Integer.bitCount(res);
        
    }
}