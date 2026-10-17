class Solution {
    private int getDigitsum(int num){
        int sum = 0;

        while(num > 0){
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }

        return sum;
    }

    public int compareByDigitSum(int num1, int num2){
        int d1 = getDigitsum(num1);
        int d2 = getDigitsum(num2);

        if(d1 != d2){
            return Integer.compare(d1, d2);
        }

        return Integer.compare(num1, num2);
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] aftersorted = new Integer[n];

        for(int i = 0; i < n; i++){
            aftersorted[i] = nums[i];
        }

        Arrays.sort(aftersorted, this::compareByDigitSum);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], i);
        }

        int swaps = 0;
        for(int i = 0; i < n; i++){
            int expected_val = aftersorted[i];
            int curr_val = nums[i];

            if(expected_val == curr_val) continue;

            nums[i] = expected_val;
            int index = map.get(expected_val);
            nums[index] = curr_val;

            map.put(expected_val, i);
            map.put(curr_val, index);

            swaps++;
        }

        return swaps;
    }
}