class Solution {
    class Node {
        TreeNode node;
        int index;
        Node(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                int index = current.index - minIndex;
                if (i == 0) first = index;
                if (i == size - 1) last = index;
                if (current.node.left != null)
                    q.offer(new Node(current.node.left, 2 * index));
                if (current.node.right != null)
                    q.offer(new Node(current.node.right, 2 * index + 1));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
