package tree;

public class FlattenBinaryTreeToLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public void flatten(TreeNode root) {
        while(root != null){
            TreeNode cur = root.left;
            if(cur == null){
                root = root.right;
                continue;
            }
            while(cur.right != null){
                cur = cur.right;
            }
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;

        }
    }
}
