/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter=0;

    int calDia(TreeNode node){
        if(node==null) return 0;
        int  lmax=calDia(node.left);
        int  rmax=calDia(node.right);
        diameter=Math.max(diameter,lmax+rmax);
        return 1+Math.max(lmax,rmax);
    }
    public int diameterOfBinaryTree(TreeNode root) {
         calDia(root);
         return diameter;
        
    }
}