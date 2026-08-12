class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max_length = 0;

        while(j < n){
            int num = nums[j];
            map.put(num, map.getOrDefault(num, 0)+1);
            while(i <= j && map.get(num) > k){
                int numb = nums[i];
                map.put(numb, map.getOrDefault(numb, 0) - 1);
                i++;
            }
            max_length = Math.max(max_length, j-i+1);
            j++;
        }

        return max_length;
    }
}