class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;

        int[] ans = new int[m];
        for(int i = 0; i < m; i++){
            ans[i] = max_size(queries[i], nums);
        }

        return ans;
    }

    int max_size(int limit, int[] nums){
        int length = 0;
        int sum = 0;
        int i = 0;
        int n = nums.length;
        while(i < n){
            sum += nums[i];
            if(sum > limit){
                break;
            }
            length++;
            i++;
        }

        return length;
    }
}