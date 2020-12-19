/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre= head;
        if (head != null){
            ListNode curr = head.next;
            while(curr != null){
                if(pre.val == curr.val)
                    pre.next= curr.next;
                else
                    pre= pre.next;
                curr= curr.next;
            }
        }
        return head;
    }
        
}