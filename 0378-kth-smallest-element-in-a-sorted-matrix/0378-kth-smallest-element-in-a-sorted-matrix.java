class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                heap.offer(matrix[i][j]);
                if(heap.size() > k){
                    heap.poll();
                }
            }
        }

        return heap.poll();
    }
}