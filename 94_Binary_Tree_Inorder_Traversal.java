/* Inorder Traversal of Binary Tree Iteratively and Recursively
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

 //Iteratively -
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> traversal = new ArrayList<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            traversal.add(current.val);
            current = current.right;
        }
        return traversal;
    }
}

//Recursively -
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        fill(root, traversal);
        return traversal;
    }
    
    public void fill(TreeNode root, List<Integer> traversal) {
        if(root == null)
            return;
        fill(root.left, traversal);
        traversal.add(root.val);
        fill(root.right, traversal);
        return;
    }
}