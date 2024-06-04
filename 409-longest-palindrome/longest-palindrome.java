class Solution {
    public int longestPalindrome(String s) {
        if(s==null ||  s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> charCount =new HashMap<>();
        for (char c: s.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c,0)+1);
        }
        int len=0;
        boolean  oddcount=false;
        for (int i:charCount.values()){
            if(i%2==0){
                len+=i;
            }
            else{
            len+=i-1;
            oddcount=true;;
            }
        }
        if(oddcount){
            len+=1;
        }
        return len;

    }
}