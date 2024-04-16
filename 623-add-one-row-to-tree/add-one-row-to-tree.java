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
    public TreeNode Add_node(TreeNode root,int val,int depth,int curr)
    {
        if(root==null)
            return null;
        if(curr==depth-1)
        {
            TreeNode ltemp=root.left;
            TreeNode rtemp=root.right;
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=ltemp;
            root.right.right=rtemp;
            return root;
        }
        root.left=Add_node(root.left,val,depth,curr+1);
        root.right=Add_node(root.right,val,depth,curr+1);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth==1)
        {
            TreeNode newRoot= new TreeNode(val);
            newRoot.left=root;
            return  newRoot;

        }
        return Add_node(root,val,depth,1);
    }
}