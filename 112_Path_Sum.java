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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return isSum(root, 0, sum);
    }
    public boolean isSum(TreeNode root, int sum, int target) {
        sum += root.val;
        if(root.left == null && root.right == null)
            if(sum == target)
                return true;
        boolean left = false;
        boolean right = false;
        if(root.left != null)
            left = isSum(root.left, sum, target);
        if(root.right != null)
            right = isSum(root.right, sum, target);
        return left || right;
    }
}