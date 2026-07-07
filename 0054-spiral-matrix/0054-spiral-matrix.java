class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;//top row
        int down = n-1;
        int leftcolumn = 0;
        int rightcolumn = m-1;

        while(top <= down && leftcolumn <= rightcolumn){
            for(int i = leftcolumn; i <= rightcolumn; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= down; i++){
                ans.add(matrix[i][rightcolumn]);
            }
            rightcolumn--;

            if(top <= down){
                for(int i = rightcolumn; i >= leftcolumn; i--){
                    ans.add(matrix[down][i]);
                }
                down--;
            }
            if(leftcolumn <= rightcolumn){
                for(int i = down; i >= top; i--){
                    ans.add(matrix[i][leftcolumn]);
                }
                leftcolumn++;
            }
        }

        return ans;
    }
}