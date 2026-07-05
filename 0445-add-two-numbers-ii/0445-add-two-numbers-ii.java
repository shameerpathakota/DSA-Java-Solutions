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
        ListNode result = new ListNode(0);
        ListNode curr = result;
        ListNode curr1 = l1;
        ListNode prev1 = null;
        
        while(curr1 != null){
            ListNode temp = curr1.next;
            curr1.next = prev1;
            prev1 = curr1;
            curr1 = temp;
        }
        
        ListNode curr2 = l2;
        ListNode prev2 = null;
        
        while(curr2 != null){
            ListNode temp = curr2.next;
            curr2.next = prev2;
            prev2 = curr2;
            curr2 = temp;
        }
        
        int carry = 0;
        while(prev1 != null || prev2 != null){
            int sum = 0 + carry;
            
            if(prev1 != null){
                sum += prev1.val;
                prev1 = prev1.next;
            }
            
            if(prev2 != null){
                sum += prev2.val;
                prev2 = prev2.next;
            }
            
            carry = sum / 10;
            sum = sum % 10;
            
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        
        if(carry == 1){
            curr.next = new ListNode(carry);
        }
        
        result = result.next;
        ListNode ans = null;
        
        while(result != null){
            ListNode temp = result.next;
            result.next = ans;
            ans = result;
            result = temp;
        }
        
        return ans;
    }
}