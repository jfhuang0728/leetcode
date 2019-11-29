package dfs;

public class ValidateBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean dfs(TreeNode node, Long min, Long max){
        if (node == null){
            return true;
        }
        if (node.val >= max || node.val <= min){
            return false;
        }
        return dfs(node.left, min, Math.min(max, node.val)) && dfs(node.right, Math.max(min, node.val), max);

    }

}
