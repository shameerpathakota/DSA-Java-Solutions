class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int max = nums[0];
        int result = 0;
        for(int i = k; i < nums.length; i++){
            max = Math.max(max, nums[i-k]);
            result = Math.max(result, max+nums[i]);
        }

        return result;
    }
}
//see younus07 account solution for recal the problem