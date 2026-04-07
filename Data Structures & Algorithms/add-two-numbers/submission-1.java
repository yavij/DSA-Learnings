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
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int num1 = convertNodeToInt(reverseNumbers(l1)); 
        int num2 = convertNodeToInt(reverseNumbers(l2)); 
        System.out.println(num1+" "+num2);
        int sum = num1+num2;
        System.out.println("sum"+sum);
        //321 --> 1,2,3

        if(sum == 0) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(sum>0){
          temp.next =  new ListNode(sum%10);
          temp = temp.next;
          sum/=10;
        }

        return dummy.next;
    }

    private ListNode reverseNumbers(ListNode node){
        ListNode curr = node;
        ListNode prev = null, next = null;

        while(curr!=null) {
            System.out.println("val"+curr.val);
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private int convertNodeToInt(ListNode node){
        int value = 0;
        while(node!=null) {
           value = value*10+node.val;
           node = node.next;
        }
        return value;
    }
}
