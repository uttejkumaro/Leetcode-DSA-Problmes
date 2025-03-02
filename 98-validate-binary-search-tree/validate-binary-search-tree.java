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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return dfs(root, null, null); // Start DFS traversal from the root node with no initial range constraints
//     }
//    boolean dfs(TreeNode node, Integer min, Integer max) {
//         // Base case: null node is a valid BST
//         if (node == null) {
//             return true;
//         }

//         // Check if current node's value violates the BST property
//         if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
//             return false;
//         }

//         // Recursively check left and right subtrees with updated range constraints
//         return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
//     }
// }
class Solution {
    public boolean isValidBST(TreeNode root) {
        ArrayList<TreeNode>al=new ArrayList<>();
        
        inOrder(root,al);
        for(int i=1;i<al.size();i++){
            if(al.get(i).val<=al.get(i-1).val) return false;

        }
        return true;
    }
    void inOrder(TreeNode root,ArrayList<TreeNode>al){
        if(root==null) return ;
        inOrder(root.left,al);
        al.add(root);
        inOrder(root.right,al);
        

    }
   
    }