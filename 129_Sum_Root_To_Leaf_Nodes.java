/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
      4
     / \
    9   0
   / \
  5   1
  Ans = 1026 -> 495 + 491 + 40
 Time Complexity - O(n)
 Space Copmlexity - O(1)
 Approach - If the left node of current node is a leaf node, make that the units's digit of number formed so far and add to sum; same for right node
            If not, make next node the unit's digit of number formed so far and perform the same check by traversing to next node
Each node is traversed only once. Hence Time Complexity of O(n).
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        int current = root.val;
        int sum = 0;
        return sumNode(root, sum, current);
    }
    public int sumNode(TreeNode root, int sum, int current) {
        if(root.right != null && root.right.right == null && root.right.left == null)
            sum += current * 10 + root.right.val;
        else
            if(root.right != null)
                sum = sumNode(root.right, sum, current * 10 + root.right.val);
        
        if(root.left != null && root.left.right == null && root.left.left == null)
            sum += current * 10 + root.left.val;
        else
            if(root.left != null)
                sum = sumNode(root.left, sum, current*10 + root.left.val);
        
        return sum;
    }
}