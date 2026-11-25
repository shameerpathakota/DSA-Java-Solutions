class Solution {
    long MOD = 1_000_000_007L;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int result = n;
        int l = 1;
        int r = n;
        long base = Arrays.stream(nums).max().getAsInt() + 1L;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(check(nums, mid, base)){
                result = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return result;
    }

    boolean check(int[] nums, int size, long base){
        int n = nums.length;
        HashMap<Long, Integer> map = new HashMap<>();
        long hash = 0;
        long p = findPower(base % MOD, size - 1);

        int i = 0;
        int j = 0;

        while(j < n){
            hash = (hash * base + nums[j]) % MOD;
            
            if(j-i+1 < size){
                j++;
            }
            else{
                map.put(hash, map.getOrDefault(hash, 0)+1);
                hash = (hash - (p * nums[i]) % MOD + MOD) % MOD;
                i++;
                j++;
            }
        }

        for(int count : map.values()){
            if(count == 1){
                return true;
            }
        }

        return false;
    }

    private long findPower(long a, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = findPower(a, exp / 2);
        long result = (half * half) % MOD;
        if (exp % 2 == 1) {
            result = (result * a) % MOD;
        }

        return result;
    }
}