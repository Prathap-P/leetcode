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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode L=new  ListNode(0, null);
        ListNode l3= L;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l3.next= l1;
                l3= l3.next;
                l1= l1.next;
            }
            else if(l1.val > l2.val){
                l3.next= l2;
                l3= l3.next;
                l2= l2.next;
            }
            
        }
        if(l1 == null)
            l3.next= l2;
        if(l2 == null)
            l3.next= l1;
        return L.next;
        
    }
}