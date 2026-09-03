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
    private int maxdiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        calculatedepth(root);
        return maxdiameter;
        
    }
    public int calculatedepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftdepth=calculatedepth(node.left);
        int rightdepth=calculatedepth(node.right);

        maxdiameter=Math.max(maxdiameter,leftdepth+rightdepth);

        return Math.max(leftdepth,rightdepth)+1;
    }
}