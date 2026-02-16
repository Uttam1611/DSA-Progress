import java.util.*;

class Solution {
    Map<String,Integer> map=new HashMap<>();
    List<TreeNode> res=new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    private String serialize(TreeNode node){
        if(node==null) return "#";
        String s=node.val+","+serialize(node.left)+","+serialize(node.right);
        if(map.getOrDefault(s,0)==1) res.add(node);
        map.put(s,map.getOrDefault(s,0)+1);
        return s;
    }
}
