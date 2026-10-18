class Solution {
    final long MOD = 1000000007;
    long[][] PT;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        PT = new long[n+1][];
        for(int i = 0; i <= n; i++){
            PT[i] = new long[i+1];
            Arrays.fill(PT[i], 1);
            for(int j = 1; j < i; j++){
                PT[i][j] = (PT[i-1][j] + PT[i-1][j-1]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }


        return (int) ((solve(list) - 1 + MOD) % MOD);

    }

    long solve(List<Integer> list){
        int m = list.size();

        if(m < 3){
            return 1;
        }

        int root = list.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 1; i < m; i++){
            if(list.get(i) < root){
                left.add(list.get(i));
            }else {
                right.add(list.get(i));
            }
        }

        long x = solve(left) % MOD;
        long y = solve(right) % MOD;

        return (((x*y) % MOD) * PT[m-1][left.size()])% MOD;
    }
}