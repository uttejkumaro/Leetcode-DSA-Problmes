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
//     List<Integer>ans=new ArrayList<>();
//     public List<Integer> postorderTraversal(TreeNode root) {
//         postOrder(root);
//         return ans;        
//     }
//     void postOrder(TreeNode node){
//         if(node==null) return;
//         postOrder(node.left);
//         postOrder(node.right);
//         ans.add(node.val);        
//     }
// }
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
     List<Integer>ans=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        if(root!=null) st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            ans.add(curr.val);
            if(curr.left!=null) st.push(curr.left);
            if(curr.right!=null) st.push(curr.right);
        
        }
        Collections.reverse(ans);
        return ans;
    }
}
/**
class Solution {
    public List<Integer> postOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node curr = stack1.pop();
            stack2.push(curr);

            // Push left and right children
            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }

        // stack2 has post-order in reverse, so pop to result
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().data);
        }

        return result;
    }
}
 
 \U0001f50e Code Idea (2-Stack Method for Postorder Traversal)

Stack1 (stack1) → used for traversal, like a “work stack”.

You pop a node, then push its children into stack1 (like in preorder).

This ensures all nodes are visited.

Stack2 (stack2) → used to reverse the visiting order.

Whatever comes out of stack1 gets pushed here.

At the end, popping from stack2 gives the correct postorder sequence.*/