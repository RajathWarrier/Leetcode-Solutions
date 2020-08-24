/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q);
    }
    
    public TreeNode search(TreeNode node, TreeNode p, TreeNode q) {
        if(p.val > node.val && q.val > node.val)
            return search(node.right, p, q);
        if(p.val < node.val && q.val < node.val)
            return search(node.left, p, q);
        return node;
    }
}