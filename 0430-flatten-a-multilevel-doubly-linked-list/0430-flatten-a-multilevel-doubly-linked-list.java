/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution{
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node curr = head;

        while(curr != null){
            if(curr.child != null){
                //flatten the list

                Node nextnode = curr.next;
                curr.next = flatten(curr.child);
                curr.child = null;
                curr.next.prev = curr;//because it is an doubly linked list


                //find the tail of the list
                while(curr.next != null) curr = curr.next;

                //attach the list with next node
                if(nextnode != null){
                    curr.next = nextnode;
                    nextnode.prev = curr;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}