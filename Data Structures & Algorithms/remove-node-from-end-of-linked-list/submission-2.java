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

        int count = 1;
        if(n==1 && head.next == null){
            return null;
        }

        head = reverseList(head);
        if(n == 1){
         return reverseList(head.next);
        }
        ListNode temp = head;

        while(temp!=null){
            if(count+1 == n){
                temp.next = temp.next.next;
            }
            count++;
            temp = temp.next;
        }

        return reverseList(head);
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
