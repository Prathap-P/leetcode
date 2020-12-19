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
    public int maxDepth(TreeNode root) {
     
        
        return calcMaxDepth(root);
        
    }

    public int calcMaxDepth(TreeNode node){

        if(node == null)return 0;
        
        int leftDepth= calcMaxDepth(node.left);
        
        int rightDepth= calcMaxDepth(node.right);

        return Math.max(leftDepth, rightDepth) +1;
    }        
        
}