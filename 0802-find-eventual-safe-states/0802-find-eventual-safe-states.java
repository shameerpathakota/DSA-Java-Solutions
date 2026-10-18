class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer>[] reverse = new ArrayList[n];
        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;

            for (int neighbor : graph[i]) {
                reverse[neighbor].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!q.isEmpty()) {
            int curr = q.remove();
            safe[curr] = true;

            for (int prev : reverse[curr]) {
                outdegree[prev]--;

                if (outdegree[prev] == 0) {
                    q.add(prev);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}
/*the idea is that we calculate the outdegree of each node.
the nodes with outdegree 0 is safe and the node having all the neighbors has also outdegree 0 is also safe
NOTE : build the graph in reverse manner.
*/