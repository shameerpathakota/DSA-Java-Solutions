class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return n;
        }
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            if(!set.contains(num-1)){
                int curr = num;
                int length = 1;

                while(set.contains(curr+1)){
                    curr++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}