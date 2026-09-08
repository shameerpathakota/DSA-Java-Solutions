class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min_length = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        int n = nums.length;

        while(right < n){
            sum += nums[right];
            while(sum >= target){
                min_length = Math.min(min_length, right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
}