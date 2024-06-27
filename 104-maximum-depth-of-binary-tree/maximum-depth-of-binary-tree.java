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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lmax=maxDepth(root.left);
        int rmax=maxDepth(root.right);
        return 1+Math.max(lmax,rmax);
        
    }
}

//Bfs
/*
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int depth=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            depth++;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
           
                }

             }

        }
        return depth;
    }
}
*/
//iterative dfs
/*
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Stack<Pair<TreeNode,Integer>>stack=new Stack<>();
        stack.push(new Pair<>(root,1));
        int depth=0;
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> pair=stack.pop();
            TreeNode node =pair.getKey();
            int currDep=pair.getValue();
            depth=Math.max(depth,currDep);

            if (node.left != null) {
                stack.push(new Pair<>(node.left, currDep + 1));
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, currDep + 1));
            }

        }
        return depth;


    }
}
*/



