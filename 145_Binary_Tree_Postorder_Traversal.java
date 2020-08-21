/* Postorder Traversal of Binary Tree Iteratively and Recursively*/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> traversal = new ArrayList<>();
        if(root == null)
            return traversal;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            traversal.add(0, currentNode.val);
            if(currentNode.left != null)
                stack.push(currentNode.left);
            if(currentNode.right != null)
                stack.push(currentNode.right);
        }
        return traversal;
    }
}

//Recursively -
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        fill(root, traversal);
        return traversal;
    }
    
    public void fill(TreeNode root, List<Integer> traversal) {
        if(root == null)
            return;
        fill(root.left, traversal);
        fill(root.right, traversal);
        traversal.add(root.val);
        return;
    }
}