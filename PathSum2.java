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
 
    List<List<Integer>> toReturn = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        insertList(root, sum, new ArrayList<Integer>());
        
        return toReturn;
    }
    
    public void insertList(TreeNode node, int sum, List<Integer> temp){
     
        if(node == null)return;
        
        temp.add(node.val);

        //LEAF NODE
        if(node.left == null && node.right == null){
            
            if(sum == node.val){
                toReturn.add(new ArrayList<>(temp));
            }    
        }
        
        //INTERNAL NODES
        else{
            
            int expected= sum - node.val;

            insertList(node.left, expected, temp);

            insertList(node.right, expected, temp);

        }
        temp.remove(temp.size()-1);
    }
    
}










