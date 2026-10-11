class Solution {
    static class Edge{
        int src;
        int dest;
        
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<Edge>[] Graph = new ArrayList[graph.length];
        for(int i = 0; i < Graph.length; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                int d = graph[i][j];
                Graph[i].add(new Edge(i, d));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        findallpaths(Graph, result, new ArrayList<>(), 0, graph.length-1);

        return result;
    }

    public void findallpaths(ArrayList<Edge>[] graph, List<List<Integer>> result, List<Integer> temp, int src, int dest){
        if(src == dest){
            temp.add(dest);
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(src);

        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i); 
            findallpaths(graph, result, temp, e.dest, dest);
            temp.remove(temp.size() - 1);
        }
    }
}