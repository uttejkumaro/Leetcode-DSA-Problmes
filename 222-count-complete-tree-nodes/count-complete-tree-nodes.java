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
    //int ans=0;
    // public int countNodes(TreeNode root) {
    //     if(root==null)return 0;
    //     int left=countNodes(root.left);
    //     int right=countNodes(root.right);
    //     return 1+left+right;
        
    // }
    public int countNodes(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null)return 0;
        q.add(root);
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            ans+=size;
            for(int i=0;i<size;i++){
            TreeNode curr=q.poll();
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
        }
        return ans;
    }
}