package array;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildByDFS(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode buildByDFS(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(postStart > postEnd){
            return null;
        }
        int place = findInorderPlace(postorder, inorder, postEnd);
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = buildByDFS(inorder, inStart, place - 1, postorder, postStart, place - inStart + postStart - 1);
        root.right = buildByDFS(inorder, place + 1, inEnd, postorder, place - inStart + postStart , postEnd - 1);
        return root;
    }
    private int findInorderPlace(int[] postorder, int[] inorder, int index){
        int val = postorder[index];
        for(int i = 0; i < inorder.length; i++){
            if(val == inorder[i]){
                return i;
            }
        }
        return -1;
    }
}
