//naive searching algo
class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        int res=Integer.MAX_VALUE;
        for(int i=0;i<=n-m;i++){
            int j;
            for( j=0;j<m;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }
            if(j==m){
                int ans=i;
                 res=Math.min(res,ans);
            }
            
            
           
        }
        return (res!=Integer.MAX_VALUE) ?res:-1;
        
    }
}