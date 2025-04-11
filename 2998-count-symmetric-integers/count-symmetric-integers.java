class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
     for(int i=low;i<=high;i++){
        String s=String.valueOf(i);
        if(s.length()%2==0){
            int mid=s.length()/2;
            int leftSum=0,rightSum=0;
            for(int j=0;j<mid;j++){
                leftSum+=s.charAt(j)-'0';                
                rightSum+=s.charAt(mid+j)-'0';
                
            }
            if(leftSum==rightSum) count++;
        }
     }
     return count;
        
    }
}