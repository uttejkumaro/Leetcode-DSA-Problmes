class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
        for(int i=0;i<words.length;i++){
            if(isPre(words[i],pref)) count++;
        }
        return count;       

    }
    boolean isPre(String s,String pre){
        if(s.length()<pre.length()) return false;
        for(int i=0;i<pre.length();i++){
            if(s.charAt(i)!=pre.charAt(i)) return false;
        }
        return true;
    }

}