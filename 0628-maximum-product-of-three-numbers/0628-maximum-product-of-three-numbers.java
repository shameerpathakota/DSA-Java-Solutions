class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int a = nums[n-1];
        int b = nums[n-2];
        int c = nums[n-3];
        int p1 = a*b*c;
        int p2 = nums[0]*nums[1]*nums[n-1];
        return Math.max(p1, p2);
    }
}