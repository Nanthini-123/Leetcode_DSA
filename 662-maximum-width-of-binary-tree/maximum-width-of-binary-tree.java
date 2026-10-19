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
    class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode node, int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Pair>queue=new LinkedList<>();
        int maxwidth=0;

        queue.add(new Pair(root,0));

        while(!queue.isEmpty()){
            int levelsize=queue.size();

            int firstindex=queue.peek().index;
            int lastindex=firstindex;

            for(int i=0;i<levelsize;i++){
                Pair current=queue.poll();
                TreeNode node=current.node;
                int currentindex=current.index;

                
                lastindex=currentindex;

                if(node.left!=null){
                    queue.add(new Pair(node.left,2*currentindex));
                }
                if(node.right!=null){
                    queue.add(new Pair(node.right,2*currentindex+1));
                }

            }
             int currentwidth=lastindex-firstindex+1;
             maxwidth=Math.max(currentwidth,maxwidth);
        }
        return maxwidth;
        
    }
}