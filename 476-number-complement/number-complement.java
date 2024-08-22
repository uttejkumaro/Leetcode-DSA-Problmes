// class Solution {
//     public int findComplement(int num) {
//         int mask=(Integer.highestOneBit(num)<<1)-1;
//         return mask^num;
//     }
// }
 class Solution {
     public int findComplement(int num) {
        int mask=0;
        int temp=num;
        while(temp>0){
            mask=(mask<<1) | 1;
            temp=temp>>1;
        }
        return num^mask;
     }
 }