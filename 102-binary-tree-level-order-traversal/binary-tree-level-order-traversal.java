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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        } 
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        List<Integer>currentlevel=new ArrayList<>();
        
        int levelsize=queue.size();       
        for(int i=0;i<levelsize;i++){
            TreeNode currentnode=queue.poll();
            currentlevel.add(currentnode.val);

            if(currentnode.left!=null){
                queue.add(currentnode.left);
            }
            if(currentnode.right!=null){
                queue.add(currentnode.right);
            }
        }
        result.add(currentlevel);
        }
        return result;
    }
}