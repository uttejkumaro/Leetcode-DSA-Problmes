class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=nums[0];
        for (int i=1;i<nums.length;i++){
            xor^=nums[i];

        }
        if(xor==k){
            return 0;
        } 
        return CountOperations(xor,k);

    }
    public int CountOperations(int x,int y){
        int bits=0; //diffferent bits
        for(int i =0;i<32;i++){
            int xLsb=((x>>i)&1);
            int yLsb=((y>>i)&1);
            if(xLsb!=yLsb){
                bits++;
            }
           
        } return bits;
    }
}