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
//     public List<Integer> preorderTraversal(TreeNode root) {
//      List<Integer>ans=new ArrayList<>();
//          preorder(root,ans);
//         return ans;   
//             }
//             void preorder(TreeNode node, List<Integer> ans){
//                 if(node==null)  return ;
//                 ans.add(node.val);
//                 preorder(node.left,ans);
//                 preorder(node.right,ans);
                
//             }
// }
// class Solution {
//     List<Integer> ans = new ArrayList<>();
//     public List<Integer> preorderTraversal(TreeNode root) {
//         if (root == null) {
//             return ans; // Return empty list if tree is empty
//         }
        
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode current = root;
        
//         while (current != null || !stack.isEmpty()) {
//             // Process all left nodes and push right children onto stack
//             while (current != null) {
//                 ans.add(current.val);         // Visit root
//                 if (current.right != null) {
//                     stack.push(current.right); // Save right child for later
//                 }
//                 current = current.left;       // Move to left child
//             }
            
//             // When no more left children, pop a right child from stack
//             if (!stack.isEmpty()) {
//                 current = stack.pop();
//             }
//         }
        
//         return ans;
//     }
// }
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
     List<Integer>ans=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        if(root!=null) st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            ans.add(curr.val);
            if(curr.right!=null) st.push(curr.right);
            if(curr.left!=null) st.push(curr.left);
        
        }
        return ans;
    }
}