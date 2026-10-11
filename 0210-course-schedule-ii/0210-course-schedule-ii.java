class Solution {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] arr : prerequisites){
            int a = arr[0];
            int b = arr[1];

            graph[b].add(new Edge(b, a));
        }

        if(detectcycle(graph)){
            return new int[] {};
        }

        int[] indegree = new int[graph.length];
        calculateindegree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int[] result = new int[graph.length];
        int index = 0;

        while(!q.isEmpty()){
            int curr = q.remove();
            result[index] = curr;
            index++;

            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        return result;
    }

    public void calculateindegree(ArrayList<Edge>[] graph, int[] indegree){
        for(int i = 0; i < graph.length; i++){
            int v = i;
            for(int j = 0; j < graph[v].size(); j++){
                Edge e = graph[v].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public boolean detectcycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                if(detectcycleutil(graph, vis, stack, i)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean detectcycleutil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack, int curr){
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest] == true){
                return true;
            }
            else if(!vis[e.dest] && detectcycleutil(graph, vis, stack, e.dest)){
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }
}