class Solution {
    class Edge {
        int src;
        int dest;

        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        int[] ans = new int[2];

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            boolean[] vis = new boolean[n+1];
            if(hasPath(graph, vis, u, v)){
                ans[0] = u;
                ans[1] = v;
            }

            else{
                graph[u].add(new Edge(u, v));
                graph[v].add(new Edge(v, u));
            }
        }

        return ans;
    }

    boolean hasPath(ArrayList<Edge>[] graph, boolean[] vis, int src, int dest){
        if(src == dest) return true;

        vis[src] = true;

        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, vis, e.dest, dest)){
                return true;
            }
        }

        return false;
    }
}