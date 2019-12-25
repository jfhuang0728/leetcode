package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
        public List<String> binaryTreePaths(TreeNode root) {
            if(root == null){
                return new ArrayList();
            }
            List<String> returnList = new ArrayList<>();
            dfs(returnList, root, String.valueOf(root.val));
            return returnList;
        }
        private void dfs(List<String> list, TreeNode node, String str){
            if(node == null){
                return;
            }
            if(node.left == null && node.right == null){
                list.add(str);
                return;
            }

            if(node.left != null){
                dfs(list, node.left, str + "->" + String.valueOf(node.left.val));
            }
            if(node.right != null){
                dfs(list, node.right, str + "->" + String.valueOf(node.right.val));
            }

        }
}
