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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        for (int[] des : descriptions) {
            int parentVal = des[0];
            int childVal = des[1];
            boolean isLeft = des[2] == 1;

            // Create parent node if it does not exist
            if (!nodeMap.containsKey(parentVal)) {
                nodeMap.put(parentVal, new TreeNode(parentVal));
            }

            // Create child node if it does not exist
            if (!nodeMap.containsKey(childVal)) {
                nodeMap.put(childVal, new TreeNode(childVal));
            }

            // Add child value to the child set
            childSet.add(childVal);

            // Assign child to the appropriate side of parent
            if (isLeft) {
                nodeMap.get(parentVal).left = nodeMap.get(childVal);
            } else {
                nodeMap.get(parentVal).right = nodeMap.get(childVal);
            }
        }

        // Identify the root node
        for (int key : nodeMap.keySet()) {
            if (!childSet.contains(key)) {
                return nodeMap.get(key);
            }
        }

        return null; // In case there's no valid tree
    }
}