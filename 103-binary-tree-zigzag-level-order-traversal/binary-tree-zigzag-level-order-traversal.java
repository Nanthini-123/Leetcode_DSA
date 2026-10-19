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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);

        boolean leftToRight=true;
        
        while(!queue.isEmpty()){
            LinkedList<Integer> currentlevel=new LinkedList<>();
            int levelsize=queue.size();
            for(int i=0;i<levelsize;i++){
                TreeNode current=queue.poll();

                if(leftToRight){
                    currentlevel.add(current.val);
                }
                else{
                    currentlevel.addFirst(current.val);
                }

                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
             result.add(currentlevel);
            leftToRight=!leftToRight;
        }
        return result;
       
        
    }
}