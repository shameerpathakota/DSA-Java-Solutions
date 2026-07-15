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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftNode = dummy;
        int l = left;

        while(l > 1){
            leftNode = leftNode.next;
            l--;
        }

        ListNode rightNode = leftNode;

        for(int i = 0; i <= right - left + 1; i++){
            rightNode = rightNode.next;
        }

        leftNode.next = reverse(leftNode.next, rightNode);

        return dummy.next;

    }

    ListNode reverse(ListNode head, ListNode rightpointer){
        ListNode prev = rightpointer;
        ListNode curr = head;

        while(curr != rightpointer){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}