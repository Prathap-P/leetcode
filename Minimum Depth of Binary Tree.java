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

import java.util.*;
class Solution {
    public int minDepth(TreeNode root) {
        
        return calcMinDepth(root);
        
    }

    public int calcMinDepth(TreeNode node){

        if(node == null)return 0;
        
        int leftDepth= calcMinDepth(node.left);
        
        int rightDepth= calcMinDepth(node.right);

        if(leftDepth != 0 && rightDepth != 0)
            return Math.min(leftDepth, rightDepth) + 1;
        
        if(leftDepth == 0)return rightDepth + 1;
        
        return leftDepth + 1;
    }

}
