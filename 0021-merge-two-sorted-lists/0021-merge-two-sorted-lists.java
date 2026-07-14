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
        ListNode duplicate = new ListNode(0);
        ListNode tail = duplicate;
        // now we have to take two pointers one for list1 and one for list2
        // then iterate by comparing the values 
        ListNode f = list1;
        ListNode s = list2;
        while(f != null && s != null){
            if(f.val < s.val){
                tail.next = f;
                f = f.next;
            }
            else{
                tail.next = s;
                s = s.next;
            }
            tail = tail.next;
        }
        if(f != null) tail.next = f;
        if(s != null) tail.next = s;
        return duplicate.next;
    }
}