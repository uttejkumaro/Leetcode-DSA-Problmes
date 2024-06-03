class Solution {
    public int appendCharacters(String s, String t) {
        int n=s.length();
        int m=t.length();
        int sidx=0,tidx=0;
        while(sidx<n && tidx<m){
        if (s.charAt(sidx)==t.charAt(tidx)){
            tidx++;         
        }
        sidx++;
        }
        return m-tidx;

        
    }
}