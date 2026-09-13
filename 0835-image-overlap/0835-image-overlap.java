class Solution {
    int CountOverlap(int[][] A, int[][] B, int rowoffset, int coloffset){
        int n = A.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int B_i = i + rowoffset;
                int B_j = j + coloffset;

                if(B_i < 0 || B_j >= n || B_i >= n || B_j < 0){
                    continue;
                }

                if(A[i][j] == 1 && B[B_i][B_j] == 1){
                    count++;
                }
            }
        }

        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for(int rowoffset = -n+1; rowoffset < n; rowoffset++){
            for(int coloffset= -n+1; coloffset < n; coloffset++){
                int count = CountOverlap(img1, img2, rowoffset, coloffset);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }

        return maxOverlap;
    }
}