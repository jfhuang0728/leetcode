package tree;

public class MinimumSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int minSum = Integer.MAX_VALUE;
    TreeNode returnNode = null;

    public TreeNode findSubtree(TreeNode root) {
        dfs(root);
        return returnNode;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int sum = left + right + node.val;
        if (sum < minSum) {
            returnNode = node;
            minSum = sum;
        }
        return sum;
    }
}