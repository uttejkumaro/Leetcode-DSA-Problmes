class Solution {
    public int reverse(int x) {
        boolean isNegative=x<0;
        int temp=0;
        x=Math.abs(x);
        while(x>0){
        if (Integer.MAX_VALUE / 10 < temp) return 0;
            temp=10*temp +x%10;
            x=x/10;

        }
        return isNegative?-temp:temp;
        
    }
}