class Solution {
    public int mirrorDistance(int n) {
        return (n-reverse(n))<0?-(n-reverse(n)):(n-reverse(n));
    }
    int reverse(int n){
        int ans=0;
        while(n!=0){
            ans=ans*10+n%10;
            n/=10;

        }
        return ans;
    }
}