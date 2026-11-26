class Solution {
    public boolean canAliceWin(int n) {
        int steps = 0;
        int total = 10;

        while(n >= total){
            n -= total;
            total -= 1;
            steps++;
        }

        return steps%2 == 1;
    }
}