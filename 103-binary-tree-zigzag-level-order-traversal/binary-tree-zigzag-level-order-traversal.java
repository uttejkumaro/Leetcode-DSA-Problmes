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
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (root == null) {
//             return result;
//         }        
//         Queue<TreeNode> Q = new LinkedList<>();
//         Q.add(root);
//         int levelId = 0;        
//         while (!Q.isEmpty()) {
//             int n = Q.size();
//             List<Integer> subResult = new ArrayList<>();
//             for (int index = 0; index < n; index++) {
//                 TreeNode currNode = Q.poll();
//                 subResult.add(currNode.val);
                
//                 if (currNode.left != null) {
//                     Q.add(currNode.left);
//                 }
//                 if (currNode.right != null) {
//                     Q.add(currNode.right);
//                 }
//             }
//             if (levelId % 2 == 1) {
//                 Collections.reverse(subResult);
//             }
//             result.add(subResult);
//             levelId++;
//         }
//         return result;
//     }
// }
//to save reversal time we use 2 stack 1 stack-left,right stack 2 right .left
 class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }   
        Stack<TreeNode>s1=new Stack<>();
        Stack<TreeNode>s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer>ele=new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode curr=s1.pop();
                ele.add(curr.val);
                if(curr.left!=null){
                    s2.add(curr.left);
                }
                 if(curr.right!=null){
                    s2.add(curr.right);
                }
            }
            if(ele.size()>0) result.add(ele);               

            
            List<Integer>ele1=new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode curr=s2.pop();
                ele1.add(curr.val);
                 if(curr.right!=null){
                    s1.add(curr.right);
                }
                if(curr.left!=null){
                    s1.add(curr.left);
                }

            }
            if(ele1.size()>0)result.add(ele1);
        }
        return result;     

    }
 }