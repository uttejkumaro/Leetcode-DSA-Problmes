class Solution {
    public int mySqrt(int x) {
        for(long  i=1;i<=x;i++){
            if(i*i==x) return (int)i;
            else if(i*i>x) return (int)i-1;
        }
        return x;
        
    }
}