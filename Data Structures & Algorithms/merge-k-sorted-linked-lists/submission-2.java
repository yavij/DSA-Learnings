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

        //Optimal Solution

        int len = lists.length;

        if(len == 0) return null;

        ListNode node1 = lists[0];

        for(int i=1;i<len;i++){
            ListNode node2 = lists[i];
            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;
            while( node1!=null && node2 != null){
                if (node1.val <= node2.val) {
                    tail.next = node1;
                    node1 = node1.next;
                } else {
                    tail.next = node2;
                    node2 = node2.next;
                }
                tail = tail.next;
            }
            tail.next = (node1 != null) ? node1 : node2;
            node1 = dummy.next;
        }
        return node1;
    }
}
