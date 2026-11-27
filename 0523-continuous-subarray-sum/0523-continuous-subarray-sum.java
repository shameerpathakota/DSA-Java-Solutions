class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(map.containsKey(sum % k)){
                if(i - map.get(sum % k) >= 2){
                    return true;
                }
            }
            else{
                map.put(sum%k, i);
            }
        }

        return false;
    }
}