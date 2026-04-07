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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1) return head;

        ListNode node1 = head; int count = 1;
        ListNode dummy = new ListNode(-1);
        ListNode tempdummy = dummy;
        ListNode temp = null;
        while(node1 != null){

            if(count == k){
                temp = node1.next;
                node1.next = null;
                ListNode reverse = getReverseNode(head);
                dummy.next = reverse;
                dummy = head;
                head.next = temp;          
                head = temp;           
                node1 = temp;
                count = 1;
                continue;    
            }
            count++;
            node1 = node1.next;
        }
        return tempdummy.next;
    }

    //Reverse a ListNode
    private ListNode getReverseNode(ListNode node){
        ListNode prev = null, next = null;
        ListNode curr = node;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
