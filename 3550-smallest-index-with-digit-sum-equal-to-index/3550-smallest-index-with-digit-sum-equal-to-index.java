class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < 9){
                if(nums[i] == i) return i;
            }
            int sum = find(nums[i]);
            if(sum == i) return i;
        }

        return -1;
    }

    int find(int n){
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }
        return sum;
    }
}