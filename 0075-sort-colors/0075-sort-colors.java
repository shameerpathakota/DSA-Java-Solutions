class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int[] freq = new int[3];

        for(int num : nums){
            freq[num]++;
        }

        int k = 0;
        for(int i = 0; i < 3; i++){
            int val = freq[i];
            if(val == 0) continue;
            for(int j = 0; j < val; j++){
                nums[k] = i;
                k++;
            }
        }
    }
}