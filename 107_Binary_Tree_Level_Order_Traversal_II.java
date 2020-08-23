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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            List<Integer> currentLevel = new ArrayList<>();
            int h = nodes.size();
            for(int i=0; i<h; i++){
                TreeNode currentNode = nodes.remove();
                currentLevel.add(currentNode.val);
                if(currentNode.left != null)
                    nodes.add(currentNode.left);
                if(currentNode.right != null)
                    nodes.add(currentNode.right);
            }
            ans.add(0, currentLevel);
        }
        return ans;
    }
}