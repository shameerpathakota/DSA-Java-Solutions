class Solution {
    class Node {
        int val;
        int index;

        Node(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;

        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            q.offer(new Node(tickets[i], i));
        }

        int time = 0;
        while(!q.isEmpty()){
            Node curr = q.poll();
            curr.val--;
            time++;

            if(curr.val == 0){
                if(curr.index == k){
                    return time;
                }
            }
            else{
                q.offer(curr);
            }
        }

        return time;
    }
}