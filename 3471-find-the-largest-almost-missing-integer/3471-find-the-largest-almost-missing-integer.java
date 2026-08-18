class Solution {
    public int largestInteger(int[] nums, int k) {
        int max = -1;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = k-1;
        while(j < n){
            int l = i;
            while(l <= j){
                map.put(nums[l], map.getOrDefault(nums[l], 0) + 1);
                l++;
            }
            j++;
            i++;
        }

        for(int key : map.keySet()){
            if(map.get(key) == 1){
                max = Math.max(max, key);
            }
        }

        return max;
    }
}