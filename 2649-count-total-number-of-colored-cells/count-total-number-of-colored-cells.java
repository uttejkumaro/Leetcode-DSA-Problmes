class Solution {
    public long coloredCells(int n) {
        long res=1;
        int add=4;
        while(n>1){
            res+=add;
            add+=4;
            n--;
        }
        return res;
        
    }
}