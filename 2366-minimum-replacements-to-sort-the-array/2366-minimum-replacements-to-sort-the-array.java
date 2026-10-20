class Solution {
    public long minimumReplacement(int[] nums) {
        //fact one here number of opearations = parts - 1;
        long operations = 0;
        int n = nums.length;

        for(int i = n-2; i >= 0; i--){
            if(nums[i] <= nums[i+1]) continue;//koyi bath nai..
            int parts = nums[i]/nums[i+1];
            if(nums[i]%nums[i+1] != 0) parts++;
            operations += parts-1;
            nums[i] = nums[i]/parts;
        }

        return operations;
    }
}