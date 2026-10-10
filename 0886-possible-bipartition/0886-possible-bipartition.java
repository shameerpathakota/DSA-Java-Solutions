class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] array : dislikes){
            int a = array[0];
            int b = array[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] col = new int[n+1];
        Arrays.fill(col, -1);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            if(col[i] == -1){
                col[i] = 0;
                q.add(i);

                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j = 0; j < graph[curr].size(); j++){
                        int neighbor = graph[curr].get(j);
                        if(col[neighbor] == -1){
                            int nxtcolor = col[curr] == 0 ? 1 : 0;
                            col[neighbor] = nxtcolor;
                            q.add(neighbor);
                        }
                        else if(col[neighbor] == col[curr]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}