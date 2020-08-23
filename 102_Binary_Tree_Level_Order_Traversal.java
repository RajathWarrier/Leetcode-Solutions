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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<List<Integer>>();
        if(root == null)
            return traversal;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<n; i++) {
                TreeNode currentNode = q.remove();
                level.add(currentNode.val);
                if(currentNode.left != null)
                    q.add(currentNode.left);
                if(currentNode.right != null)
                    q.add(currentNode.right);
            }
            traversal.add(level);
        }
        return traversal;
    }
}