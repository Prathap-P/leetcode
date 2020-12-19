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
    public ListNode detectCycle(ListNode head) {
        ListNode temp= head;
        while(true){
            if(temp == null)return null;
            else if (temp.val == Integer.MAX_VALUE)return temp;
            else {
                temp.val= Integer.MAX_VALUE;
                temp= temp.next;    
             }   
         }
        
    }
}