/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            Node[] currentLevel = new Node[n];
            for(int i=0; i<n; i++) {
                Node currentNode = q.remove();
                currentLevel[i] = currentNode;
                if(currentNode.left != null)
                    q.add(currentNode.left);
                if(currentNode.right != null)
                    q.add(currentNode.right);
            }
            for(int j=0; j<n - 1; j++)
                currentLevel[j].next = currentLevel[j + 1];
            currentLevel[n - 1].next = null;
        }
        return root;
    }
}