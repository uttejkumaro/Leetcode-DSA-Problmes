class Solution {
    public int passThePillow(int n, int time) {
        // 1 to n and n to 1 total sum is 2*(n-1)
        int pos=time%(2*(n-1));
        if(pos<n){
            return pos+1;
        }  
        return 2*n-1-pos; 
    }
}