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

        //edge case
        if(lists.length == 0) return null;

        //Brute force 

        List<Integer> values = new ArrayList<>();

        for(ListNode node: lists){
            while(node!=null){
                values.add(node.val);
                node = node.next;
            }
        }

        Collections.sort(values);

        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;

        for(int val: values){
            dummy.next = new ListNode(val);
            dummy = dummy.next;
        }
        
        return temp.next;
    }
}
