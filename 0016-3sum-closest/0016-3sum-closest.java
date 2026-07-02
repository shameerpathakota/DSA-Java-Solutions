class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i + 1;
            int r = n - 1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];

                if(sum == target){
                   return sum;
                }

                else if(sum > target){
                    r--;
                }
                else{
                    l++;
                }
                int diff = Math.abs(sum-target);
                if(diff < min){
                    result = sum;
                    min = diff;
                }
            }
        }

        return result;
    }
}