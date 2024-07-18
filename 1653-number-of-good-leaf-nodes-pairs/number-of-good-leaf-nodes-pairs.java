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
    int count;
    public int countPairs(TreeNode root, int distance) {
        count=0;

        dfs(root,distance);
        return count;
    }

    private List<Integer> dfs(TreeNode root, int distance){
        if(root == null){
            return new ArrayList<>();
        }

        if(root.left == null && root.right == null){
            List<Integer> dist=new ArrayList<>();
            dist.add(1);
            return dist;
        }

        List<Integer> left=dfs(root.left,distance);
        List<Integer> right=dfs(root.right,distance);

        for(int l:left){
            for(int r:right){
                int totalDist=l+r;
                if(totalDist<=distance){
                    count++;
                }
            }
        }
        for(int i=0;i<left.size();i++){
            left.set(i,left.get(i)+1);
        }

        for(int i=0;i<right.size();i++){
            left.add(right.get(i)+1);
        }        
        return left;
    }


}