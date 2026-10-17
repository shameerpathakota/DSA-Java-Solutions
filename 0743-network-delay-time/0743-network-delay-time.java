class Solution {
    static class Pair implements Comparable<Pair> {
        int v;
        int path;

        public Pair(int v, int path){
            this.v = v;
            this.path = path;
        }

        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    private void CreateGraph(int[][] times, ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] arr : times){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];

            graph[u].add(new Edge(u, v, w));
        }

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        CreateGraph(times, graph);

        int[] dist = new int[n+1];
        for(int i = 1; i < dist.length; i++){
            if(i != k){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(k, 0));

        while(!q.isEmpty()){
            Pair curr = q.remove();

            for(int i = 0; i < graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u]+wt;
                    q.add(new Pair(v, dist[v]));
                }
            }
        }

        for(int i = 1; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
        }

        int min_time = 0;
        for(int d : dist){
            min_time = Math.max(min_time, d);
        }

        return min_time;
    }
}