class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for(int num : nums1){
            min = Math.min(min, num);
        }
        if(min % 2 == 1){
            return true;//smallest number is odd and any number - odd number will always gives you odd number
        }

        for(int num : nums1){
            if(num % 2 == 1){
                return false;
            }
        }

        return true;// all the nums1 elements are even
    }
}