class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0;
        HashSet<Integer> set = new HashSet<>();
        long curr_sum = 0;
        long max_sum = 0;
        for(int j = 0; j < nums.length; j++){
            if(!set.contains(nums[j])){
                curr_sum += nums[j];
                set.add(nums[j]);

                if(j-i+1 == k){
                max_sum = Math.max(curr_sum, max_sum);
                curr_sum -= nums[i];
                set.remove(nums[i]);
                i++;
                }
            }
            else{
                while(nums[i] != nums[j]){
                    curr_sum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
                i++;
            }
        }

        return max_sum;
    }
}