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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }

    public boolean check(TreeNode node1, TreeNode node2){
        
        if(node1 == null && node2 == null)return true;

        if(node1 == null || node2 == null)return false;
        
        boolean flag;
        
        if(node1.val != node2.val)return false;
        
        flag= check(node1.left, node2.left);

        if(!flag)return false;

        return check(node1.right, node2.right);
        
        
    }

}