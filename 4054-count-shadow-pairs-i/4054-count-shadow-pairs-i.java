class Solution {
    public long shadowPairs(int[] nums) {
        long count = 0;
        int n = nums.length;
        int[] nxtsmaller = new int[n];
        Arrays.fill(nxtsmaller, n);
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for(int i = n-2; i >= 0; i--){
            if(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                nxtsmaller[i] = stack.peek();
                stack.push(i);
            }
            else{
                while(!stack.isEmpty()){
                    stack.pop();
                    if(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                        nxtsmaller[i] = stack.peek();
                        stack.push(i);
                        break;
                    }
                }
            }
            if(stack.isEmpty()){
                stack.push(i);
            }
        }

       HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
       for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
       }

       for(int i = 0; i < n-1; i++){
            int equal_count = findceiling(map.get(nums[i]), nxtsmaller[i]) - findceiling(map.get(nums[i]), i+1);
            int range = nxtsmaller[i] - i - 1;
            count += (range - equal_count);
       }

        return count;
    }

    int findceiling(ArrayList<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = left + (right - left)/2;
            if(list.get(mid) < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}