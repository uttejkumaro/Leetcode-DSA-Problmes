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
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper( preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    TreeNode helper(int preorder[],int min,int max){
        if(idx>=preorder.length) return null;
        int val=preorder[idx];
        TreeNode root=new TreeNode(val);
        if(val<min || val>max) return null;
        idx++;
        root.left=helper(preorder,min,val);
        root.right=helper(preorder,val,max);
        return root;

    }
}