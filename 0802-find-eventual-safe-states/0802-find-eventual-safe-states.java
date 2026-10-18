class Solution {
    class Edge {
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Edge>[] Graph = new ArrayList[graph.length];
        List<Integer> ans = new ArrayList<>();
        CreateGraph(graph, Graph);
        int[] outdegree = new int[graph.length];
        Calculate_Outdegree(Graph, outdegree);

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < outdegree.length; i++){
            if(outdegree[i] == 0){
                q.add(i);
            }
        }

        boolean[] safe = new boolean[graph.length];
        while(!q.isEmpty()){
            int curr = q.poll();
            safe[curr] = true;

            for(int i = 0; i < Graph[curr].size(); i++){
                Edge e = Graph[curr].get(i);
                outdegree[e.dest]--;
                if(outdegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        for(int i = 0; i < safe.length; i++){
            if(safe[i]){
                ans.add(i);
            }
        }

        return ans;
    }

    public void CreateGraph(int[][] graph, ArrayList<Edge>[] Graph){
        for(int i = 0; i < graph.length; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                int u = i;
                int v = graph[i][j];
                Graph[v].add(new Edge(v, u));
            }
        }
    }

    void Calculate_Outdegree(ArrayList<Edge>[] Graph, int[] outdegree){
        for(int i = 0; i < Graph.length; i++){
            for(int j = 0; j < Graph[i].size(); j++){
                Edge e = Graph[i].get(j);
                outdegree[e.dest]++;
            }
        }
    }
}
/*the idea is that we calculate the outdegree of each node.
the nodes with outdegree 0 is safe and the node having all the neighbors has also outdegree 0 is also safe*/