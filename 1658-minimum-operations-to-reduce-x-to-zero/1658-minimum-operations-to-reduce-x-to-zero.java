class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i++){
            sum += nums[i];
            map.put(sum, i);
        }
        if(sum < x) return -1;

        int longest = Integer.MIN_VALUE;
        int target_sum = sum - x;

        sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            int complement = sum - target_sum;
            if(map.containsKey(complement)){
                longest = Math.max(longest, i - map.get(complement));
            }
        }

        return longest == Integer.MIN_VALUE ? -1 : n-longest;
    }
}