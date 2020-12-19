/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp= head;
        while(true){
            if(temp == null)return false;
            else if (temp.val == Integer.MAX_VALUE)return true;
            else {
                temp.val= Integer.MAX_VALUE;
                temp= temp.next;    
             }   
         }
    }
}