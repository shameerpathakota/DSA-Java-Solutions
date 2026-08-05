class Solution {
    class Edge{
        int src;
        int dest;

        public Edge(int u, int v){
            this.src = u;
            this.dest = v;
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] arr : invocations){
            int u = arr[0];
            int v = arr[1];

            graph[u].add(new Edge(u,v));
        }
        boolean[] suspicious = new boolean[n];
        bfs(graph, k, suspicious);

        List<Integer> ans = new ArrayList<>();

        for(int[] arr : invocations){
            int u = arr[0];
            int v = arr[1];

            if(!suspicious[u] && suspicious[v]){
                for(int i = 0; i < n; i++){
                    ans.add(i);
                }
                return ans;
            }
        }

        for(int i = 0; i < n; i++){
            if(!suspicious[i]){
                ans.add(i);
            }
        }

        return ans;
        
    }

    void bfs(ArrayList<Edge>[] graph, int start, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(!visited[e.dest]){
                    visited[e.dest] = true;
                    q.offer(e.dest);
                }
            }
        }
    }
}