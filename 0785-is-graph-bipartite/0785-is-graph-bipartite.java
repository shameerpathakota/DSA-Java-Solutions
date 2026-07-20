class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];

        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < v; i++){
            if(color[i] != -1){
                continue;
            }

            q.offer(i);
            color[i] = 0;

            while(!q.isEmpty()){
                int curr = q.remove();
                for(int neighbor : graph[curr]){
                    if(color[neighbor] == -1){
                        int nxt_color = color[curr] == 0 ? 1 : 0;
                        color[neighbor] = nxt_color;
                        q.add(neighbor);
                    }
                    else if(color[neighbor] == color[curr]){
                        return false;
                    }
                    
                }
            }

        }
        return true;
    }
}