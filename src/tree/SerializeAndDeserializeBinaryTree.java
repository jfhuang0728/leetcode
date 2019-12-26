package tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public String serialize(TreeNode root) {
        if(root == null){
            return "{}";
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for(int i = 0; i < queue.size(); i++){
            TreeNode node = queue.get(i);
            if(node == null){
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        //最后叶节点的左右节点为null也加入了queue，因此要移除
        while(queue.get(queue.size() - 1) == null){
            queue.remove(queue.size() - 1);
        }
        StringBuffer str = new StringBuffer();
        str.append("{");
        str.append(queue.get(0).val);
        for(int i = 1; i < queue.size(); i++){
            if(queue.get(i) == null){
                str.append(",#");
            }else{
                str.append(",");
                str.append(queue.get(i).val);
            }
        }
        str.append("}");
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("{}")){
            return null;
        }
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        List<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int index = 0;
        boolean isLeft = true;
        for(int i = 1; i < nodes.length; i++){
            if(!nodes[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
                if(isLeft){
                    queue.get(index).left = node;
                }else{
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if(!isLeft){
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}
