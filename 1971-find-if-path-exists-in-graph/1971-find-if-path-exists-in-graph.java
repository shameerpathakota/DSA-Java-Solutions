class Solution {
    class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(new Edge(u, v, 1));
            graph[v].add(new Edge(v, u, 1));
        }

        return hasPath(graph, source, destination, new boolean[n]);
    }

    boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean[] v){
        if(src == des){
            return true;
        }

        v[src] = true;

        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);

            if(!v[e.dest] && hasPath(graph, e.dest, des, v)){
                return true;
            }
        }

        return false;
    }
}