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
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if(p==null && q==null){
//             return true;
//         }
//          if(p==null ||  q==null){
//             return false;
//         }
//          if(p.val!=q.val){
//             return false;
//         }
//         return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);     
//     }
// }
//post-order and pre-order traversals preserve the structural properties of a binary tree, while in-order does not
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer>a=new ArrayList<>();
        ArrayList<Integer>b=new ArrayList<>();
        preorder(b,p);
        preorder(a,q);
        return a.equals(b);
    }
    void preorder(ArrayList<Integer>a,TreeNode p){
        if(p==null){
            a.add(Integer.MIN_VALUE);

        return ;
        } 
        a.add(p.val);
        preorder(a,p.left);
        preorder(a,p.right);
    }
}
