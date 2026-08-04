class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();


        for(int num : nums){
            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for(int i = min; i <= max; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }
}