package tree;

public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class ResultType{
        boolean isBalanced;
        int depth;
        public ResultType(boolean isBalanced, int depth){
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }
    private ResultType dfs(TreeNode node){
        if(node == null){
            return new ResultType(true, 0);
        }
        ResultType left = dfs(node.left);
        ResultType right = dfs(node.right);
        int rootDepth = Math.max(left.depth, right.depth) + 1;
        if(Math.abs(left.depth - right.depth) <= 1 && left.isBalanced && right.isBalanced){
            return new ResultType(true, rootDepth);
        }else{
            return new ResultType(false, rootDepth);
        }
    }
}
