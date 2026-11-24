class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m;
    int n;
    public int shortestPath(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int steps = 0;
        boolean[][][] vis = new boolean[m+1][n+1][k+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, k});

        while(!q.isEmpty()){
            int N = q.size();

            while(N-- > 0){
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];
                int obs = arr[2];

                if(r == m-1 && c == n-1){
                    return steps;
                }

                for(int[] dir : directions){
                    int new_r = r + dir[0];
                    int new_c = c + dir[1];

                    if(new_r < 0 || new_r >= m || new_c < 0 || new_c >= n){
                        continue;
                    }

                    if(grid[new_r][new_c] == 0 && !vis[new_r][new_c][obs]){
                        q.add(new int[]{new_r, new_c, obs});
                        vis[new_r][new_c][obs] = true;
                    }
                    else if(grid[new_r][new_c] == 1 && obs > 0 && !vis[new_r][new_c][obs-1]){
                        q.add(new int[]{new_r, new_c, obs-1});
                        vis[new_r][new_c][obs-1] = true;
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}