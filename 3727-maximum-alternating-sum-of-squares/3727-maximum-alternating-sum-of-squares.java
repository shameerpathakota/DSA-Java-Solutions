class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[i] = nums[i]*nums[i];
        }

        Arrays.sort(nums);
        long n_sum = 0;
        long p_sum = 0;

        for(int i = 0; i < n/2; i++){
            n_sum += nums[i];
        }
        for(int i = n/2; i< n; i++){
            p_sum += nums[i];
        }

        return p_sum - n_sum;
    }
}