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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        dfs(root,0,result);
            return result;
        
    }    
        public void dfs(TreeNode node, int depthsize, List<Integer> result){
            if(node==null){
                return;
            }

            if(depthsize==result.size()){
                result.add(node.val);
            }

            dfs(node.right,depthsize+1,result);
            dfs(node.left,depthsize+1,result);

    
        }
}