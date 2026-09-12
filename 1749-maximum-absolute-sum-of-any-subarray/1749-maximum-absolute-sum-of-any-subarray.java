class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max_sum = findmax(nums, n);
        int min_sum = findmin(nums, n);

        return Math.max(max_sum, -1*min_sum);
    }

    int findmin(int[] nums, int n){
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            min = Math.min(min, sum);

            if(sum > 0){
                sum = 0;
            }
        }

        return min;
    }

    int findmax(int[] nums, int n){
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}