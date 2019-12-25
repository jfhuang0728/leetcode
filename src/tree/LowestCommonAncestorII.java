package tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorII {
    class ParentTreeNode {
      public ParentTreeNode parent, left, right;
        int val;
        ParentTreeNode(int x) {
            val = x;
        }
    }
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        List<ParentTreeNode> listA = new ArrayList<>();
        List<ParentTreeNode> listB = new ArrayList<>();
        dfs(root, B, listB);
        dfs(root, A, listA);
        for(int i = 0; i <= listA.size() - 1; i++){
            for(int j = 0; j <= listB.size() - 1; j++){
                if(listA.get(i).val == listB.get(j).val){
                    return listA.get(i);
                }
            }
        }
        return null;
    }
    private void dfs(ParentTreeNode root, ParentTreeNode node, List<ParentTreeNode> list){

        while(node != null){
            list.add(node);
            node = node.parent;
        }
    }
}
