class Solution {
    public int minimumDeletions(int[] nums) {
        //base case
        if(nums.length == 1){
            return 1;
        }

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int max_index = -1;
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        int pop_front = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] > max){
                max = nums[i];
                max_index = i;
            }
            if(nums[i] < min){
                min = nums[i];
                min_index = i;
            }
        }

        int big = -1;
        int small = -1;
        if(max_index > min_index){
            big = max_index;
            small = min_index;
        }
        else{
            big = min_index;
            small = max_index;
        }

        pop_front = big+1;// remove from front both the elements
        int pop_back = n - small;
        
        int fpop = small+1;
        int bpop = n-big;

        

        return Math.min(pop_front, Math.min(pop_back, fpop+bpop));
    }
}