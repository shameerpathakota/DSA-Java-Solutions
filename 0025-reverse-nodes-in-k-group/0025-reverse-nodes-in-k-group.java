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
        if(head == null){
            return null;
        }

        int total = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            total++;
        }

        if(total < k){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp1 = dummy;

        while(total >= k){
            ListNode temp2 = temp1;
            int l = k;
            while (l > 0){
                temp2 = temp2.next;
                l--;
            }

            ListNode nxtgroup = temp2.next;
            ListNode start = temp1.next;

            temp1.next = reverse(start, nxtgroup);
            temp1 = start;
            total = total - k;
        }

        return dummy.next;
    }

    ListNode reverse(ListNode head, ListNode nxtgroup){
        ListNode prev = nxtgroup;
        ListNode curr = head;

        while(curr != nxtgroup){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}