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
    public boolean hasPathSum(TreeNode node, int sum) {
        
        if(node == null)
            return false;
        
        
        //leaves
        if(node.left == null && node.right == null){
            
            if(sum == node.val)
                return true;
            
            return false;
            
        }
        
        //internal nodes
        int expected= sum - node.val;
        
        boolean proceed=  hasPathSum(node.left, expected);
        
        if(proceed)
            return true;
        
        return hasPathSum(node.right, expected);
    }
}



