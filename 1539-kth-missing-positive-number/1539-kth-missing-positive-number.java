class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr){
            set.add(num);
        }

        int currentNum = 1;

        while(k > 0){
            if(!set.contains(currentNum)){
                k--;
                if(k == 0){
                    return currentNum;
                }
            }
            currentNum++;
        }

        return -1;
    }
}