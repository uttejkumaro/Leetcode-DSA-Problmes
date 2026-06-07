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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode>mp=new HashMap<>();
        Set<Integer>children=new HashSet<>();
        for(int []desc:descriptions){
            int par=desc[0];
            int child=desc[1];
            int isLeft = desc[2];
            mp.putIfAbsent(par,new TreeNode(par));
            mp.putIfAbsent(child,new TreeNode(child));
            children.add(child);
            if(isLeft==1)mp.get(par).left=mp.get(child);
            else mp.get(par).right=mp.get(child);

        }
        for(int desc[]:descriptions){
            int par=desc[0];
            if(!children.contains(par))return mp.get(par);
        }
        return null;

    }
}