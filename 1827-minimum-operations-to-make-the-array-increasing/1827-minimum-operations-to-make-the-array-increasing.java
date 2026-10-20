class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        int operations = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]) continue;

            int count = 0;
            while(nums[i] <= nums[i-1]){
                count++;
                nums[i] += 1;
            }
            operations += count;
        }

        return operations;
    }
}