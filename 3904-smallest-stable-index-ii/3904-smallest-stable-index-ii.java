class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minFromIndex = new int[n];
        minFromIndex[n-1] = nums[n-1];

        for(int i = n-2; i >= 0; i--){
            minFromIndex[i] = Math.min(nums[i], minFromIndex[i+1]);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            if(max - minFromIndex[i] <= k){
                return i;
            }
        }

        return -1;
    }
}