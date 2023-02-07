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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode curr = new ListNode();
        ListNode he = curr;
        List<ListNode> al = new LinkedList();

        while( head!= null){
            curr.next = new ListNode(head.val);
            al.add(head);
            head = head.next;
            curr = curr.next;
        }

        System.out.println( al.size() - n-1 );

        if( ( al.size() - n-1) < 0){
            if( al.size() == 1){
                return null;
            }
            return al.get(1);
        }

        al.get( al.size() - n-1 ).next = (al.size() - n +1) > (al.size()-1) ? null : al.get( al.size() - n +1) ;

        // System.out.println( al.get( al.size() - n-1 ).next.val +" -"+al.get( al.size() - n +1).val);

        return al.get(0);
    }
}