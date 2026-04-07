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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        //Brute force approach

        List<Integer> values = new ArrayList<>();

        while(list1!=null){
            values.add(list1.val);
            list1 = list1.next;
        }

        while(list2!=null){
            values.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(values);

        ListNode result = new ListNode(values.get(0));
        ListNode head = new ListNode(values.get(1));
        result.next = head;

        for(int i=2;i<values.size();i++){
            head.next = new ListNode(values.get(i));
            head = head.next;
        }
        
        return result;
        
    }
}