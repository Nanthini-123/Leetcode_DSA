/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer>prefixmap=new HashMap<>();

        prefixmap.put(0L,1);
        return dfs(root,0L,targetSum,prefixmap);
    }
    public int dfs(TreeNode node,Long currentsum,int targetSum,Map<Long,Integer> prefixmap){
        if(node==null){
            return 0;
        }

        currentsum+=node.val;

        int validpaths=prefixmap.getOrDefault((long)(currentsum-targetSum),0);

        prefixmap.put(currentsum,prefixmap.getOrDefault(currentsum,0)+1);

        validpaths+=dfs(node.left,currentsum,targetSum,prefixmap);
        validpaths+=dfs(node.right,currentsum,targetSum,prefixmap);

        prefixmap.put(currentsum,prefixmap.get(currentsum)-1);

        return validpaths;
    }
}