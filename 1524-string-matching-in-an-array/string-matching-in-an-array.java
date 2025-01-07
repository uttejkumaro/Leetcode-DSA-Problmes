public class Solution {
    public List<String>stringMatching(String[] words) {
        List<String>result=new ArrayList<>();
        for(int i = 0; i<words.length; i++) {
            int[] lps=computeLPS(words[i]);
            for (int j=0;j<words.length; j++) {
                if (i == j) continue; 
                if(isSubstring(words[i],words[j],lps)){
                    result.add(words[i]);
                    break; 
                }
            }
        }
        return result;
    }
    private int[]computeLPS(String pattern){
        int[] lps=new int[pattern.length()];
        int len = 0,i = 1;
        while(i<pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(len)){
                lps[i++] = ++len;
            }
            else if(len > 0) {
                len =lps[len - 1];
            }
            else {
                lps[i++]=0;
            }
        }
        return lps;
    }
    private boolean isSubstring(String sub, String main, int[] lps){
        int i = 0, j = 0;
        while (i < main.length()) {
            if(main.charAt(i)==sub.charAt(j)) {
                i++;
                j++;
                if (j==sub.length()) return true; // Found a match.
            }
            else if(j >0) {
                j=lps[j-1];
            }
            else{
                i++;
            }
        }
        return false; // No match found.
    }
}
