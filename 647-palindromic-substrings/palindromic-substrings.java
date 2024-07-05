class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=countSubString(s,i,i);//odd length
            count+=countSubString(s,i,i+1);//even  length
        }
        return count;
    }
    int countSubString(String s,int left,int right){
        int count=0;
        while(left>=0 && right<s.length() &&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
