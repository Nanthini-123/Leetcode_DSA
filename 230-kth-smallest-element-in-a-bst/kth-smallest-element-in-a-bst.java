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
    public int kthSmallest(TreeNode root, int k) {
        int [] positiontracker =new int[]{0};
        int[] result=new int[]{-1};

        inordersearch(root,k,positiontracker,result);

        return result[0];
        
    }

    public void inordersearch(TreeNode node,int k, int[] positiontracker, int[]result){
        if(node==null||positiontracker[0]>=k){
            return;
        }

        inordersearch(node.left,k,positiontracker,result);

        positiontracker[0]++;

        if(positiontracker[0]==k){
            result[0]=node.val;
            return ;
        }
        inordersearch(node.right,k,positiontracker,result);


    }
}