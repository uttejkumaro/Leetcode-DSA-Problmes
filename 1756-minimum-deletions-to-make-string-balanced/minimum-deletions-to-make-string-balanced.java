class Solution {
    public int minimumDeletions(String s) {
        int totalA=0; 
        for(char c:s.toCharArray()){                
                if(c=='a'){
                    totalA++;
                }
        }
            int minDel=totalA;
            int countB=0;
            int countA=totalA;
            for(char c:s.toCharArray()){
                if(c=='a'){
                    countA--;
                }
                else{
                    countB++;
                }
                
            minDel=Math.min(minDel,countB+countA);
            }
         return minDel;
        
    }
}