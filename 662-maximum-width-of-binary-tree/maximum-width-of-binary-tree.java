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
 class pair<k,v>{
    k key;
    v value;
    pair(k key,v value ){
        this.key=key;
        this.value=value;
    }
        k getKey(){return key;}
        v getValue() {
        return value;
        }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<pair<TreeNode,Integer>>q=new LinkedList<>();
        q.add(new pair<>(root,0));
        int max=0;
        while(!q.isEmpty()){
           int size=q.size();
             int left=0;
            int right=0;
           for(int i=0;i<size;i++){
            
           pair<TreeNode, Integer> pair = q.poll();
                TreeNode node = pair.getKey();
                int pos = pair.getValue();
            if(i==0) left=pos;
            if(i==size-1) right=pos;
            if(node.left!=null) q.add(new pair<>( node.left,2*pos));
            if(node.right!=null) q.add(new pair<>(node.right,2*pos+1));
           }
            max=Math.max(max,right-left+1);
        }
        return max;
        
    
    }
}