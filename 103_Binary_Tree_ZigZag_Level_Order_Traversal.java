/*Level Order Traversal of Binary Tree, L to R, R to L
Time Complexity - O(n)
Approach - Queue elements of each level and keep adding.
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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null)
            return zigzag;
        boolean direction = false;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int h = nodes.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<h; i++) {
                TreeNode currentNode = nodes.poll();
                if(direction)
                    currentLevel.add(0, currentNode.val);
                else
                    currentLevel.add(currentNode.val);
                if(currentNode.left != null)
                    nodes.add(currentNode.left);
                if(currentNode.right != null)
                    nodes.add(currentNode.right);
            }
            direction = !direction;
            zigzag.add(currentLevel);
        }
        return zigzag;
    }
}