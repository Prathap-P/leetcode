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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> toReturn= new ArrayList<>();
        
        inOrder(toReturn, root);
        
        return toReturn;
    }
    
    public void inOrder(List<Integer>list, TreeNode node){
        if(node == null)
            return;
            
        inOrder(list, node.left);
        list.add(node.val);
        inOrder(list, node.right);

    }
}