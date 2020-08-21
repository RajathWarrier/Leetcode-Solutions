/*
Preorder Traversal of Binary Tree, Recursively and Iteratively
*/

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

//Recursively
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        fill(root, traversal);
        return traversal;
    }
    
    public void fill(TreeNode root, List<Integer> nodeList) {
        if(root != null) {
            nodeList.add(root.val);
            fill(root.left, nodeList);
            fill(root.right, nodeList);
        }
        return;*/
    }
}

//Iteratively
/* Have 2 lists--one that will keep updating nodes when encountered in preorder manner, another one that will update values of encountered node 
from node list into value list */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> traversal = new ArrayList<>();
        int i = 0;
        nodes.add(root);
        while(i < nodes.size()) {
            TreeNode node = nodes.get(i);
            traversal.add(node.val);
            if(node.right != null)
                nodes.add(i + 1, node.right);
            if(node.left != null)
                nodes.add(i + 1, node.left);
            i++;
        }
        return traversal;
    }
}