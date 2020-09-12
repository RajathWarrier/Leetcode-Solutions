/**Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * Approach - Perform Level Order Traversal. The last element on each level is the rightmost node on that level. Add it to the list
 * Time Complexit - O(n)
 * Space Complexity - O(n)
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if(root == null)
            return rightSide;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int n = nodes.size();
            TreeNode currNode = new TreeNode();
            for(int i=0; i<n; i++) {
                currNode = nodes.poll();
                if(currNode.left != null)
                    nodes.add(currNode.left);
                if(currNode.right != null)
                    nodes.add(currNode.right);
            }
            rightSide.add(currNode.val);
        }
        return rightSide;
    }
}