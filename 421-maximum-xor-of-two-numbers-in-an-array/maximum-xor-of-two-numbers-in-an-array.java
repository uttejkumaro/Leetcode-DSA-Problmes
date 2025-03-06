// class Solution {
//     public int findMaximumXOR(int[] nums) {
//         int res=0;
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 int xor=nums[i]^nums[j];
//                 res=Math.max(xor,res);
                
//             }
//         }
//         return res;
        
//     }
// }
class Solution {
    class Trie{
        Trie[]Children =new Trie[2];//0-1

    }
    Trie root=new Trie();
    void insert(int num){
        Trie node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i) &1;
            if(node.Children [bit]==null){
                node.Children [bit]=new Trie();
            }
            node=node.Children [bit];
        }
    }
     public int findMaximumXOR(int[] nums) {
        int maxres=0;
        for(int num:nums){
            insert(num);
        }
        for(int num:nums){
            maxres=Math.max(maxres,findmax(num));
        }
        return maxres;
     }
     int findmax(int num){
        Trie node=root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i) &1;
            int oppbit=1-bit;
            if (node.Children [oppbit] != null) {
                max |= (1 << i); // Set the i-th bit in maxXOR
                node = node.Children  [oppbit];
            } else {
                node = node.Children  [bit]; // Fall back to same bit if opposite not found
            }
        }
        return max;

     }
}