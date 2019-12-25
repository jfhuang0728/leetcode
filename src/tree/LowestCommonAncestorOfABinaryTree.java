package tree;

public class LowestCommonAncestorOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class ResultType{
        TreeNode root;
        boolean isContains;
        public ResultType(TreeNode root, boolean isContains){
            this.root = root;
            this.isContains = isContains;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ResultType result = dfs(root, p, q);
        return result.root;
    }
    private ResultType dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return new ResultType(null, false);
        }
        ResultType left = dfs(root.left, p, q);
        ResultType right = dfs(root.right, p, q);
        // System.out.println(root.val);
        // System.out.println(left.isContains);
        // System.out.println(right.isContains);
        if((left.isContains && right.isContains) || root.val == p.val || root.val == q.val){
            return new ResultType(root, true);
        }
        if(left.isContains){
            return new ResultType(left.root, true);
        }
        if(right.isContains){
            return new ResultType(right.root, true);
        }
        return new ResultType(root, false);
    }
}
