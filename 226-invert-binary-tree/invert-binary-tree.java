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
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }
        public void traverse(TreeNode node){
            if(node==null){
                return ;
            }
              // Swap the left and right children
          TreeNode temp  =node.left;
            node.left=node.right;
            node.right=temp;
            traverse(node.right);
            traverse(node.left);

        
        
    }
}