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
    public ListNode oddEvenList(ListNode head) {
        ListNode p1= head;
        ListNode P= new ListNode(0, null);
        ListNode p2= P;
        if(head == null)return head;
        while(true){
            if(p1.next == null){
                p2.next= null;
                p1.next= P.next;
                return head;
            }
            else{
                p2.next= p1.next;
                p1.next= p1.next.next;
                p2= p2.next;
                if(p1.next == null){
                    p2.next= null;
                    p1.next= P.next;
                    return head;
                }
                p1= p1.next;
            }
            
        }
    }
}