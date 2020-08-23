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
    public int maxDepth(TreeNode root) {
        //Bottom Up Approach
        return currentNode(root, 0);
    }
    public int currentNode(TreeNode node, int count) {
        if(node == null)
            return count;
        count++;
        int lcount = currentNode(node.left, count);
        int rcount = currentNode(node.right, count);
        return Math.max(lcount, rcount);
    }
}