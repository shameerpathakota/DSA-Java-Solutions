class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int total_elements = rows * columns;
        int start = 0;
        int end = total_elements-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int row = mid / columns;
            int col = mid % columns;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
        }

        return false;
    }
}