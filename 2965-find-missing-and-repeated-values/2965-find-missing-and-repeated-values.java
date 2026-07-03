class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                while(true){
                    int expected = grid[i][j] - 1;
                    int correctrow = expected / n;
                    int correctcolumn = expected % n;

                    if(grid[i][j] != grid[correctrow][correctcolumn]){
                        int temp = grid[correctrow][correctcolumn];
                        grid[correctrow][correctcolumn] = grid[i][j];
                        grid[i][j] = temp;
                    }else{
                        break;
                    }
                }
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int expected = i * n + j + 1;
                if(grid[i][j] != expected){
                    return new int[] {grid[i][j], expected};
                }
            }
        }

        return new int[] {-1, -1};
    }
}