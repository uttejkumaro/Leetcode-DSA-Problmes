class Solution {
    public String removeOccurrences(String s, String part) {
        int n=s.length();
        int m=part.length();
           
        while(s.contains(part)){
            int st=s.indexOf(part);
            s=s.substring(0,st)+s.substring(st+m);
        }
        return s;
        
    }
}