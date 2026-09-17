class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int n = arr.length;

        int[] minlenTillIdx = new int[n];
        Arrays.fill(minlenTillIdx, Integer.MAX_VALUE);
        int bestans = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        while(j < n){
            sum += arr[j];

            while(i <= j && sum > target){
                sum -= arr[i];
                i++;
            }

            if(sum == target){
                int len = j-i+1;
                if(i > 0 && minlenTillIdx[i-1] != Integer.MAX_VALUE){
                    result = Math.min(result, len+minlenTillIdx[i-1]);
                }
                bestans = Math.min(bestans, len);
            }

            minlenTillIdx[j] = bestans;
            j++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }
}