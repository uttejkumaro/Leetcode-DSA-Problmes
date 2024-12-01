class Solution {
    public int smallestNumber(int n) {
        int l =Integer.toBinaryString(n).length();
        StringBuilder sv=new StringBuilder();
        while(l-->0){
            sv.append('1');
        }
        return Integer.parseInt(sv.toString(),2);
        
        
    }
}