class Solution {
    public int minimumChairs(String s) {
        int count=0;        
        int n=s.length();
        int maxChairs=0;
        for (int i=0;i<n;i++){
            if (s.charAt(i)=='E'){
                count++;
            }else{
                count--;
            }
           maxChairs=Math.max(maxChairs,count);

        }
         return maxChairs;
        
    }
}