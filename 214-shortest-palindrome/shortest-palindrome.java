class Solution {
    public int[] lps(String s){
        int n=s.length();
        int len=0;
        int i=1;
        int lps[]=new int[n];
        while(i<n){
            if(s.charAt(len)==s.charAt(i)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }

        }
        return lps;

    }
    public String shortestPalindrome(String s) {
      String reversed=new StringBuilder(s).reverse().toString();
      String combine=s+"#"+reversed;
      int n=combine.length();
      int lps[]=lps(combine);
      int longps=lps[combine.length()-1];
      String remSuffix=reversed.substring(0,s.length()-longps);
      return remSuffix+s;       
        
    }
}