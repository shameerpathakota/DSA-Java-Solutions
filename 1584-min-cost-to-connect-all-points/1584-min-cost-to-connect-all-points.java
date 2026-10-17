class Solution {
    class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int c){
            this.v = v;
            this.cost = c;
        }

        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        CreateGraph(points, graph);
        int finalcost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0));
        boolean[] vis = new boolean[graph.length];

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalcost += curr.cost;

                for(int i = 0; i < graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    int v= e.dest;
                    int wt = e.wt;
                    if(!vis[v]){
                        pq.offer(new Pair(v, wt));
                    }
                }
            }
        }


        return finalcost;

    }

    private void CreateGraph(int[][] points, ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < graph.length - 1; i++){
            for(int j = i + 1; j < graph.length; j++){
                int dist = calculate_dist(points[i], points[j]);

                graph[i].add(new Edge(i, j, dist));
                graph[j].add(new Edge(j, i, dist));
            }
        }

    }

    private int calculate_dist(int[] x, int[] y){
        int mod_x = Math.abs(x[0] - y[0]);
        int mod_y = Math.abs(x[1] - y[1]);

        return mod_x + mod_y;
    }
}