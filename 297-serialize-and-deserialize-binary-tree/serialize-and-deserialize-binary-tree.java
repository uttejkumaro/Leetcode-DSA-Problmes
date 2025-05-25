/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return null;
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null) sb.append("null" ).append(" ");
            else {
                sb.append(node.val).append(" ");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
         
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("null")) return null;
        String[] s=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int i=1;
         while(!q.isEmpty()){
            TreeNode curr=q.poll();
            String cval=s[i];
            if(!cval.equals("null")){
                curr.left=new TreeNode(Integer.parseInt(cval));
                q.add(curr.left);
            }
            i++;
            if(i>=s.length) break;
            cval=s[i];
             if(!cval.equals("null")){
                curr.right=new TreeNode(Integer.parseInt(cval));
                q.add(curr.right);
            }
            i++;
         }
         return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));