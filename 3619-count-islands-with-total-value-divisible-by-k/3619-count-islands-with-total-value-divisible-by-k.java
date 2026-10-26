class Solution {
    int m, n;
    int[][] directions;
    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    long sum = dfs(grid, i, j);
                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    long dfs(int[][] grid, int r, int c){

        long sum = grid[r][c];
        grid[r][c] = 0;

        for(int[] dir : directions){
            int new_r = r + dir[0];
            int new_c = c + dir[1];

            if(new_r >= 0 && new_r < m && new_c >= 0 && new_c < n && grid[new_r][new_c] > 0){
                sum += dfs(grid, new_r, new_c);
            }
        }

        return sum;
    }
}