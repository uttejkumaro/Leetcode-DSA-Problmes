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
      int pre=0,post=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode curr=new TreeNode(preorder[pre]);
        pre++;
        if(curr.val!=postorder[post]){
            curr.left=constructFromPrePost(preorder,postorder);
        }
        if(curr.val!=postorder[post]){
            curr.right=constructFromPrePost(preorder,postorder);
        }
        post++;
        return curr;
    }
}