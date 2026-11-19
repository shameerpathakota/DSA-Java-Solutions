class Solution {
    public static int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 3){
            return 0;
        }
        int min_score_1 = nums[n-1] - nums[2];
        int min_score_2 = nums[n-3] - nums[0];
        int min_score_3 = nums[n-2] - nums[1];
        return Math.min(min_score_2, Math.min(min_score_1, min_score_3));

    }
}