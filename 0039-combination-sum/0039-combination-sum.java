class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, int target, int start, List<Integer> list, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        else if(target < 0){
            return;
        }

        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, target-nums[i], i, list, result);
            list.remove(list.size()-1);
        }
    }
}