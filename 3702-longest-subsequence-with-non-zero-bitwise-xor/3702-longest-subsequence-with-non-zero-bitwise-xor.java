class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean allzeros = true;
        int xor = 0;


        for(int num : nums){
            xor ^= num;
            if(num != 0){
                allzeros = false;
            }
        }

        if(allzeros){
            return 0;
        }

        return xor == 0 ? n-1 : n;
    }
}