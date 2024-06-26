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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>val=new ArrayList<>();
        inorder(root,val);
        return BST(val,0,val.size()-1);
                       
    }
    private void inorder(TreeNode root,List<Integer>val){
        if(root==null){
            return;
        }
        inorder(root.left,val);
        val.add(root.val);
        inorder(root.right,val);
     

    }
    private TreeNode BST(List<Integer>val,int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode node =new TreeNode(val.get(mid));
        node.left=BST(val,start,mid-1);
        node.right=BST(val,mid+1,end);
        return node;
    }
}