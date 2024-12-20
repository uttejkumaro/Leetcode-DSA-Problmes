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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode>q=new LinkedList();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            List<TreeNode>levelNodes=new ArrayList<>();
            for(int i=0;i<size;i++){
              TreeNode curr=q.poll();
              levelNodes.add(curr);
              if(curr.left!=null)q.add(curr.left);
              if(curr.right!=null)q.add(curr.right);


            }
            //swap odd numbered level 
            if(level%2!=0){
                int n=levelNodes.size();
                for(int i=0;i<n/2;i++){
                    int temp=levelNodes.get(i).val;
                    levelNodes.get(i).val=levelNodes.get(n-i-1).val;
                    levelNodes.get(n-i-1).val=temp;



                }
            }
            level++;

            
        }
        return root;

        
    }
}