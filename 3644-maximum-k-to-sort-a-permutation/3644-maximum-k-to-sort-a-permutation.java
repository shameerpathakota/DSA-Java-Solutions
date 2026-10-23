class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        boolean flag = true;

        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]){
                flag = false;
                break;
            }
        }

        if(flag){
            return 0;
        }

        int result = 0;
        boolean isFirst = true;

        for(int index = 0; index < n; index++){
            if(nums[index] != index){
                int a = 0;
                if(isFirst){
                    isFirst = false;
                    result = nums[index];
                }
                else{
                    result = result & nums[index];
                }
            }
        }

        return result;
    }
}