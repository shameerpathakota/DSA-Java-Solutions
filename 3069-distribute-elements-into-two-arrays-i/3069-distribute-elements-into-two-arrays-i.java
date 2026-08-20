class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        int n = nums.length;
        if(n == 2){
            return nums;
        }
        int i = 2;
        while(i < n){
            if(list1.get(list1.size() - 1) > list2.get(list2.size() - 1)){
                list1.add(nums[i]);
            }
            else{
                list2.add(nums[i]);
            }

            i++;
        }
        
        int j = 0;
        while(j < list1.size()){
            nums[j] = list1.get(j);
            j++;
        }

        for(int k = 0; k < list2.size(); k++){
            nums[j] = list2.get(k);
            j++;
        }

        return nums;
    }
}