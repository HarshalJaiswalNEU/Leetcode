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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode res = new ListNode();
        ListNode head = res;
        int carry = 0;
        
        while( l1 != null || l2 != null || carry  != 0){
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;
            
            if( (i1+i2+carry ) >= 10 ){
                res.next = new ListNode( (i1+i2+carry ) %10 );
                carry = (i1+i2+carry ) /10;
            }else{
                res.next = new ListNode( (i1+i2+carry )  );
                carry = 0;
            }
            res = res.next; 
            
            if( l1 != null){
                l1 = l1.next;
            }
            if( l2 != null){
                l2 = l2.next;
            }
            
            
            
            
        }
        
        return head.next;
    }
}