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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode>al=new ArrayList<>();
        preorder(root,al);
        for(int i=0;i<al.size()-1;i++){
            TreeNode curr=al.get(i);
            TreeNode next=al.get(i+1);
            curr.left=null;
            curr.right=next;
        }
    }
    void preorder(TreeNode root,ArrayList<TreeNode>al){
        if(root==null){
            return;
        }
      al.add(root);
      preorder(root.left,al);
        preorder(root.right,al);
    }    
}
/**
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        // Step 1: Flatten left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Step 2: Store original right subtree
        TreeNode tempRight = root.right;

        // Step 3: Move left subtree to the right
        root.right = root.left;
        root.left = null;

        // Step 4: Find the tail of the new right subtree
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        // Step 5: Attach the old right subtree
        curr.right = tempRight;
    }
}
 */