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
    public int pairSum(ListNode head) {
        if(head == null){
            return 0;
        }

        ListNode fast = head;
        ListNode slow = head;

        Stack<Integer> stack = new Stack<>();
        
        ListNode temp = head;

        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        
        int maxi = 0;

        while(fast != null && fast.next != null){
            int max = slow.val + stack.pop();
            maxi = Math.max(maxi, max);
            fast = fast.next.next;
            slow = slow.next;
        }

        return maxi;
    }
}