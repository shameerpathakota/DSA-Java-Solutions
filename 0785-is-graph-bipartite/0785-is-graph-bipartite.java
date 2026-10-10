class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;

        int col[] = new int[v];
        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < v; i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0;

                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int neighbor : graph[curr]){
                        if(col[neighbor] == -1){
                            int nextcolor = col[curr] == 0 ? 1 : 0;
                            col[neighbor] = nextcolor;
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