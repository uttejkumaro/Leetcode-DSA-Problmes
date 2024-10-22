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
 //maxheap-bfs level order
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        PriorityQueue<Long>pq=new PriorityQueue<>(Collections.reverseOrder());//max heap-rev the heap
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode pop=q.remove();
                sum+=pop.val;
                if(pop.left!=null){
                    q.add(pop.left);
                }
                 if(pop.right!=null){
                    q.add(pop.right);
                }
            }
            pq.add(sum);
        }
        if(pq.size()<k) return -1;
        for(int i=0;i<k-1;i++){
            pq.remove();
        }
        return pq.peek();
    }
}