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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        int n = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            n++;
        }

        k = k % n;
        if(k == 0){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null){
            fast = fast.next;
        }

        fast.next = slow;

        for(int i = 0; i < n-k-1; i++){
            slow = slow.next;
        }

        ListNode newhead = slow.next;
        slow.next = null;

        return newhead;

    }
}