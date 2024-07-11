/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     //TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);          
        
    }
    int dfs(TreeNode node,int max){
        if(node==null){
            return 0;
        }
        int count =0;
        if(node.val>=max){
            count++;
            max=node.val;
        }
        count+=dfs(node.left,max);
        count+=dfs(node.right,max);
        return count;
    }
}*/
class Solution {
        int res=0;
    public int goodNodes(TreeNode root) {
            dfs(root,root.val);
        return res;
    }
     void dfs(TreeNode node,int max){
        if(node==null){
            return ;
        }
        if(node.val>=max){
            res++;
        }
        max=Math.max(max,node.val);
        dfs(node.left,max);
        dfs(node.right,max);
     }
}
