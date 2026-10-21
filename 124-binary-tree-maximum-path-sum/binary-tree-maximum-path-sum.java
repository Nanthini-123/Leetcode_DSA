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
    // Stores the maximum path sum found so far
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the max gain from left and right subtrees.
        // If a subtree path sum is negative, ignore it by taking Math.max(0, ...).
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Price of a new path: current node value plus gains from both children
        int currentPathSum = node.val + leftGain + rightGain;

        // Update the global maximum if the current path is better
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the max gain the parent node can get by choosing this node
        // and either its left or right child path
        return node.val + Math.max(leftGain, rightGain);
    }
}
