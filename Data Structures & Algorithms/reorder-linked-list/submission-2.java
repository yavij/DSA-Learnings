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
    public void reorderList(ListNode head) {
        
        /**
        Optimized approach
        Time Complexity - o(n)
        Space Complexity - o(1)
        **/

        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){ //move the fast to end and slow to middle
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the second half -> fast
       ListNode curr = slow.next;
       slow.next = null;

       ListNode prev = null;

       while(curr!=null){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }

        ListNode first = head;
        ListNode second = prev;
        //Now join the slow and fast
        while(second!=null){
           ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
        
    }
}
