class Solution {
    class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    class Info {
        int v;
        int cost;
        int k;

        public Info(int v, int cost, int k){
            this.v = v;
            this.cost = cost;
            this.k = k;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        CreateGraph(flights, graph);

        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.poll();

            if(curr.k > k){
                break;
            }

            for(int i = 0; i < graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v= e.dest;
                int wt = e.wt;

                if( curr.cost + wt < dist[v]){
                    dist[v] = curr.cost + wt;
                    q.offer(new Info(v, dist[v], curr.k+1));
                }
            }
        }

        if(dist[dst] != Integer.MAX_VALUE){
            return dist[dst];
        }

        return -1;

    }

    private void CreateGraph(int[][] flights, ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] arr : flights){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];

            graph[u].add(new Edge(u, v, wt));
        }
    }
}