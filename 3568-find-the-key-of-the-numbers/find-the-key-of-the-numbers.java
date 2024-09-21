class Solution {
    public int generateKey(int num1, int num2, int num3) {
    int ans=0;
    for(int i=0;i<=3;i++){
        int digit=Math.min(num1%10,Math.min(num2%10,num3%10));
        ans=ans+digit*(int)Math.pow(10,i);
        num1/=10;
        num2/=10;
        num3/=10;
    }
    return ans;
    }
}