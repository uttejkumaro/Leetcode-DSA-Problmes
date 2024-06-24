class Solution {
    public int characterReplacement(String s, int k) {
        int count[]=new int[26];//array for store chars
        int l=0;
        int Mcount=0;
        int Mlen=0;
        for(int r=0;r<s.length();r++){
            count[s.charAt(r)-'A']++;
             Mcount=Math.max(Mcount,count[s.charAt(r)-'A']);
             while(r-l+1-Mcount>k){
                  count[s.charAt(l) - 'A']--;
                // Move the left pointer to shrink the window
                l++;
             }
              Mlen = Math.max(Mlen, r - l + 1);
            
        }
        return   Mlen ;

    }
}