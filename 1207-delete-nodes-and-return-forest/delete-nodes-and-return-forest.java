public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        
        root = helper(root, toDeleteSet, forest);
        if (root != null) {
            forest.add(root);
        }
        
        return forest;
    }
    
    private TreeNode helper(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }
        
        node.left = helper(node.left, toDeleteSet, forest);
        node.right = helper(node.right, toDeleteSet, forest);
        
        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null; // Returning null to effectively delete the node
        }
        
        return node;
    }
}
