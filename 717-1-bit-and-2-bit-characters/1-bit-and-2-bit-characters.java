class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        boolean flag=false;
        //int end=0;
        int i=0;
        for(i=0;i<n;i++){
        if(i==n-1){
            return true;
        }
            if(bits[i]==1)i++;
        }
        return false;

    }
}