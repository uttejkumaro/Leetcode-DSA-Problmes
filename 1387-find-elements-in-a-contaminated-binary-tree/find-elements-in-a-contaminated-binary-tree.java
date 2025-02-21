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
class FindElements {
     HashSet<Integer>set=new HashSet<>();

    public FindElements(TreeNode root) {
        if(root!=null) {
            root.val=0;
            set.add(0);
            recover(root);
        }
        
        
    }
    void recover(TreeNode root){
        if(root.left!=null){
            root.left.val=root.val*2+1;
            set.add(root.left.val);
           recover(root.left);
        }
         if(root.right!=null){
             root.right.val=root.val*2+2;
            set.add(root.right.val);
            recover(root.right);
        }
    }
    
    public boolean find(int target) {
        if(set.contains(target)) return true;
        else{
        return false;
        }

        
        
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */