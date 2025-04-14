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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         inOrder(root);
//         return ans;        
//     }
//     void inOrder(TreeNode node){
//         if(node==null) return;
//         inOrder(node.left);
//         ans.add(node.val);
//         inOrder(node.right);
//     }
// }
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer>ans=new ArrayList<>();
//         Stack<TreeNode>st=new Stack<>();
//         TreeNode curr=root;
//         while(true){
//             if(curr!=null){
//                 st.push(curr);
//                 curr=curr.left;
//             }
//             else{
//                 if(st.isEmpty()) break;
                
//                      curr=st.pop();
//                     ans.add(curr.val);
//                     curr=curr.right;
                
//             }
//         }
//         return ans;
//     }
// }
class Pair{
    int state;
    TreeNode node;
    Pair(TreeNode node,int state ){
        this.state=state;
        this.node=node;
    }
}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>pre=new ArrayList<>();
        List<Integer>post=new ArrayList<>();
        List<Integer>in=new ArrayList<>();
        Stack<Pair>st=new Stack<>();
        if (root == null) return in;

        st.push( new Pair(root,1));
        while(!st.isEmpty()){
            Pair curr=st.pop();
            if(curr.state==1){
                pre.add(curr.node.val);
                curr.state++;
                st.push(curr);
                if(curr.node.left!=null){
                    st.push(new Pair(curr.node.left,1));
                }
            }
            else if(curr.state==2){
                in.add(curr.node.val);
                curr.state++;
                st.push(curr);
                if(curr.node.right!=null){
                    st.push(new Pair(curr.node.right,1));
                }

            }
            else{
                post.add(curr.node.val);
            }
        }
        return in;

    
    }
}