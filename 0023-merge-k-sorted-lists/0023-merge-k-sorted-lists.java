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
    public ListNode mergeKLists(ListNode[] lists) {

        if( lists.length ==0){
            return null;
        }

        ListNode res = lists[0]; 
        ListNode a ;
        for(int i= 1; i< lists.length; i++){
            a = lists[i] ;
            res = mergeTwo(res, a);
        }

        return res;

    }

    public ListNode mergeTwo(ListNode l1, ListNode l2){
        
        ListNode res = new ListNode();
        ListNode head = res;
        while( l1 != null || l2 != null){
            int i1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int i2 = l2 == null ? Integer.MAX_VALUE : l2.val;

            if( i1 < i2){
                res.next = new ListNode(i1);
                l1 = l1.next;
            }else{
                res.next = new ListNode(i2);
                l2 = l2.next;
            }
            res = res.next;
        }

        return head.next ; 

    }
}