class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int c1=coordinate1.charAt(0)-'a'+coordinate1.charAt(1)-'0';
        int c2=coordinate2.charAt(0)-'a'+coordinate2.charAt(1)-'0';
        if((c1%2==0 && c2%2==0)||(c1%2==1 && c2%2==1))
        return true;
        return false;

    }
}