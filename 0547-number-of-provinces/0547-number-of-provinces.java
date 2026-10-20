class Solution {
    class Edge {
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<Edge>[] graph = new ArrayList[isConnected.length+1];
        CreateGraph(isConnected, graph);
        return dfs(graph);
    }
    int dfs(ArrayList<Edge>[] graph){
        int provinces = 0;
        boolean[] vis = new boolean[graph.length];
        for(int i = 1; i < graph.length; i++){
            if(!vis[i]){
                dfsutil(graph, vis, i);
                provinces++;
            }
        }

        return provinces;
    }

    void dfsutil(ArrayList<Edge>[] graph, boolean[] vis, int curr){
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsutil(graph, vis, e.dest);
            }
        }
    }
    void CreateGraph(int[][] edges, ArrayList<Edge>[] graph){
        for(int i = 1; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < edges[i].length; j++){
                if(edges[i][j] == 1 && i != j){
                    int u = i + 1;
                    int v = j + 1;
                    graph[u].add(new Edge(u, v));
                }    
            }
        }
    }
}