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
    public int minimumOperations(TreeNode root) {
         if (root == null) return 0;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
             int levelSize = q.size();
            int val[]=new int[levelSize];
            for(int i=0;i<levelSize;i++){
                TreeNode node=q.poll();
                val[i]=node.val;
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);

            }
            count+=min(val);
        }
        return count;
        
    }
    int min(int []arr){
        int c=0;
        int target[]=arr.clone();
        Arrays.sort(target);
        Map<Integer,Integer>pos=new HashMap<>();
        for(int i=0;i<arr.length;i++) pos.put(arr[i],i);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=target[i]){
                c++;
                int curr=pos.get(target[i]);
                pos.put(arr[i],curr);
                arr[curr]=arr[i];
            }
        }
        return c;
    }
}