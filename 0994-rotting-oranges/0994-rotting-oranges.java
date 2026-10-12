class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int freshcount = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i, j});
                }
                else if(grid[i][j] == 1){
                    freshcount++;
                }
            }
        }

        if(freshcount == 0){
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        while(!q.isEmpty()){
            int N = q.size();

            while(N-- > 0){
                int[] curr = q.remove();

                int i = curr[0];
                int j = curr[1];

                for(int[] d : directions){
                    int new_i = i + d[0];
                    int new_j = j + d[1];

                    if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1){
                        freshcount--;
                        grid[new_i][new_j] = 2;
                        q.add(new int[] {new_i, new_j});
                    }
                }
            }

            minutes++;
        }

        return freshcount == 0 ? minutes-1 : -1;

    }
}