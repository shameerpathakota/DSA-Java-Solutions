class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        result[0] = nums[deque.peekFirst()];
        for(int i = k; i < n; i++){
            if(deque.peekFirst() <= i-k){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);

            result[i-k+1] = nums[deque.peekFirst()];
        }

        return result;
    }
}
/*We are using monotonic Deque here and 
 we are storing the index values in decreasing order
 */
