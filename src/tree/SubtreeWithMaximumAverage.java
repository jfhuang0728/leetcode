package tree;

public class SubtreeWithMaximumAverage {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class ResultType{
        double sum;
        double num;
        TreeNode root;
        public ResultType(double sum, double num, TreeNode root){
            this.sum = sum;
            this.num = num;
            this.root = root;
        }
    }
    TreeNode returnNode;
    double average = Double.NEGATIVE_INFINITY;
    public TreeNode findSubtree2(TreeNode root) {
        dfs(root);
        return returnNode;
    }

    private ResultType dfs(TreeNode root){
        if(root == null){
            return new ResultType(0, 0, null);
        }
        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);
        double newSum = left.sum + right.sum + root.val;
        double newNum = left.num + right.num + 1;
        if(newSum / newNum - average > 0){
            average = newSum / newNum;
            returnNode = root;

        }
        return new ResultType(newSum, newNum, root);

    }
}
