package array;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildByDFS(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode buildByDFS(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }
        int rootPlaceInorder = findInorderRoot(preorder, inorder, preStart);
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildByDFS(preorder, preStart + 1, rootPlaceInorder - inStart + preStart, inorder, inStart, rootPlaceInorder - 1);
        root.right = buildByDFS(preorder, rootPlaceInorder - inStart + preStart + 1, preEnd, inorder, rootPlaceInorder + 1, inEnd);
        return root;
    }
    private int findInorderRoot(int[] preorder, int[] inorder, int index){
        int val = preorder[index];
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}
