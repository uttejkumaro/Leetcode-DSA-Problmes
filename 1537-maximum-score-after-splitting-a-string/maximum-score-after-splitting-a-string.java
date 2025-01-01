class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int res=0;
        for(int  i=0;i<n-1;i++){
            int ans=0;
            for(int j=0;j<i+1;j++){
                if(s.charAt(j)=='0'){
                    ans++;

                }
            }
            for(int j=i+1;j<n;j++){
                if(s.charAt(j)=='1'){
                    ans++;
                }
            }
            res=Math.max(ans,res);
        }
        return res;

        
    }
}