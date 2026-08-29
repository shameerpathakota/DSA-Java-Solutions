class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[] vec = nums.clone();
        Arrays.sort(vec);//sort the array.


        //group the numbers
        HashMap<Integer, Integer> numToGroup = new HashMap<>();//this is to deistingush that which number is belongs to which group
        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();

        int groupnum = 0;
        numToGroup.put(vec[0], 0);
        groupToList.putIfAbsent(groupnum, new LinkedList<>());
        groupToList.get(groupnum).add(vec[0]);

        //add the remaining numbers
        for(int i = 1; i < n; i++){
            if(Math.abs(vec[i]-vec[i-1]) > limit){
                groupnum++;
            }
            numToGroup.put(vec[i], groupnum);
            groupToList.putIfAbsent(groupnum, new LinkedList<>());
            groupToList.get(groupnum).add(vec[i]);
        }


        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int group = numToGroup.get(num);
            result[i] = groupToList.get(group).pollFirst();
        }

        return result;



    }
}