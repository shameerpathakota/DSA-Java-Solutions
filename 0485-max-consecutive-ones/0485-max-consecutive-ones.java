class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int end = 0;
        int n = nums.length;
        int max_length = 0;
        while(end < n){
            while(end < n && nums[end] == 1){
                end++;
            }
            int length = end - start;
            max_length = Math.max(max_length, length);
            while(end < n && nums[end] == 0){
                end++;
            }
            start = end;
        }
        return max_length;
    }
}