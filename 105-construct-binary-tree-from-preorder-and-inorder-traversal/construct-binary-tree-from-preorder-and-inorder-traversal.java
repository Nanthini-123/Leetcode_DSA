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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer>inordermap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inordermap.put(inorder[i],i);
        }
        int[] preorderpointer=new int[]{0};
        return buildtree(preorder,preorderpointer,inordermap,0,inorder.length-1);
        
    }
    private TreeNode buildtree(int[] preorder,int[] preorderpointer, Map<Integer,Integer>inordermap,int leftboundary,int rightboundary){
        if(leftboundary>rightboundary){
            return null;
        }

        int rootvalue=preorder[preorderpointer[0]];
        TreeNode root=new TreeNode(rootvalue);

        preorderpointer[0]++;

        int inorderindex=inordermap.get(rootvalue);

        root.left=buildtree(preorder,preorderpointer,inordermap,leftboundary,inorderindex-1);
        root.right=buildtree(preorder,preorderpointer,inordermap,inorderindex+1,rightboundary);

        return root;
    }
}