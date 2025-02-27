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
    TreeMap<Integer,List<int[]>>tp=new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>>res=new ArrayList<>();
        for(Integer x:tp.keySet()){
            List<int []> nodes=tp.get(x);
            nodes.sort(
                (a,b)->{
                    if(a[0]!=b[0]) return a[0]-b[0];
                    else return a[1]-b[1];
                }
            );
        ArrayList<Integer>lis=new ArrayList<>();
        for(int []node:nodes){
            lis.add(node[1]);
        }
        res.add(lis);
        }
        return res;
        
    }
    void dfs(TreeNode  node,int x,int y){
        if(node ==null) return ;
        tp.putIfAbsent(x,new ArrayList<>());
        tp.get(x).add(new int[]{y,node.val});
        dfs(node.left,x-1,y+1);//left child
        dfs(node.right ,x+1,y+1);//right child;
    } 
}