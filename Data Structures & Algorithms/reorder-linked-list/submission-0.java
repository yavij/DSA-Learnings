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

        //Brute force Solution

        List<Integer> values = new ArrayList<>();

        ListNode curr = head; 

        while(curr!=null){
            values.add(curr.val);
            curr = curr.next;
        }

        curr = head;
        int left = 0, right = values.size()-1;

        while(left<right){
            curr.val = values.get(left++);
            curr = curr.next;

            curr.val = values.get(right--);
            curr = curr.next;
        }

        if (left == right) {
            curr.val = values.get(left);
        }
        
    }
}
