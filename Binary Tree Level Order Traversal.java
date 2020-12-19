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
    
    List<List<Integer>> toReturn= new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        DFS(root, 0);
        
        return toReturn;
    }
    
    public void DFS(TreeNode node, int level){
        
        if(node == null)return;
        
        if(toReturn.size()-1 == level-1)
            toReturn.add(new ArrayList());

        DFS(node.left, level+1);
        

//        System.out.println(toReturn.size());
        //      System.out.println(node.val);
        
        toReturn.get(level).add(node.val);
        
        DFS(node.right, level+1);
        
    }
    
    
}