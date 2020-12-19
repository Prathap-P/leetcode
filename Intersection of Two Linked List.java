/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA= headA; 
        ListNode pB= headB;
        //ListNode pb= headB;
        if(pA == null || pB == null) return null;
        int count= 0;
        while(count <= 2){
            if(pA == pB) return pA;
            
                if(pA == null){
                    pA= headB;
                    pB= pB.next;
                    count++;
                    continue;
                }
                if(pB == null) {
                    pB= headA;
                    count++;
                    pA= pA.next;
                    continue;
                }
                pA= pA.next;
                pB= pB.next;    
        }
        return null;
        
    }
}