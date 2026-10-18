class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] state = new int[n];

        for(int i = 0; i < n; i++){
            if(dfs(graph, state, i)){
                ans.add(i);
            }
        }

        return ans;
    }

    boolean dfs(int[][] graph, int[] state, int curr){
        if(state[curr] == 1){
            return false;//means the curr nodes is involved in the cycle. it is currently in the DFS Path
        }
        if(state[curr] == 2){
            return true;//means the curr node is safe node
        }

        state[curr] = 1;

        for(int i = 0; i < graph[curr].length; i++){
            if(!dfs(graph, state, graph[curr][i])){
                return false;
            }
        }

        state[curr] = 2;
        return true;
    }
}