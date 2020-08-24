/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* Space Complexity - O(n)
   Time Complexity - O(n)
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q);        
    }
    public TreeNode search(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null)
            return null;
        if(node.val == q.val || node.val == p.val)
            return node;
        TreeNode left = search(node.left, p, q);
        TreeNode right = search(node.right, p, q);
        if(left == null)
            return right;
        if(right == null)
            return left;
        return node;
    }
}