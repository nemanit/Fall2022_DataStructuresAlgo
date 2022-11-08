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
class BSTIterator {

    // used to store all the element values in inorder DFS
    ArrayList<Integer> nodeValuesinOrderDFS;
    int index;

    public BSTIterator(TreeNode root) {
        this.nodeValuesinOrderDFS = new ArrayList<Integer>();
        // initializing as -1 as the element will be used if there are any elements in given BST
        this.index = -1;
        // initializes nodeValuesinOrderDFS by traversing BST in inorder DFS.
        this.inorderDFSTraversal(root);
    }

    public int next() {
        int nextIndexValue = ++this.index;
        return this.nodeValuesinOrderDFS.get(nextIndexValue);
    }

    public boolean hasNext() {
        int nextIndexValue = this.index + 1;
        int lengthOfTree = nodeValuesinOrderDFS.size();
        return nextIndexValue < lengthOfTree;
    }

    private void inorderDFSTraversal(TreeNode root) {
        // if given tree is null or traversal reaches leaves
        if (root == null) {
            return;
        }
        this.inorderDFSTraversal(root.left);
        this.nodeValuesinOrderDFS.add(root.val);
        this.inorderDFSTraversal(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */