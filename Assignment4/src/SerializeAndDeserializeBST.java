/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    ArrayList<Integer> nodeValuesinOrderDFS;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        preOrderTraversal(root, stringBuilder);

        return stringBuilder.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        if (data.equals("")) {
            return null;
        }

        String[] stringValueNodes = data.split(",");
        String rootStringVal = stringValueNodes[0];
        TreeNode root = new TreeNode(Integer.parseInt(rootStringVal));

        for (int i=1; i<stringValueNodes.length; i++) {
            int nodeValue = Integer.parseInt(stringValueNodes[i]);
            buildBSTTree(root, nodeValue);
        }

        return root;
    }

    private void buildBSTTree(TreeNode root, int nodeValue) {

        TreeNode currentNode = root;
        TreeNode parentNode = null;
        while (currentNode != null) {
            parentNode = currentNode;

            currentNode = (nodeValue <= currentNode.val) ? currentNode.left : currentNode.right;
        }
        if (nodeValue <= parentNode.val) {
            parentNode.left = new TreeNode(nodeValue);
        } else {
            parentNode.right = new TreeNode(nodeValue);
        }
    }



    private void preOrderTraversal(TreeNode root, StringBuilder stringBuilder) {

        if(root == null)
            return;

        stringBuilder.append(root.val).append(",");
        preOrderTraversal(root.left, stringBuilder);
        preOrderTraversal(root.right, stringBuilder);
    }

}