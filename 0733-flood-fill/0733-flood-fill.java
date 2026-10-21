class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        solve(image, sr, sc, color, image[sr][sc], vis);
        return image;
    }

    private void solve(int[][] image, int sr, int sc, int color, int original_color, boolean[][] vis) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != original_color || vis[sr][sc] == true){
            return;
        }
        
        image[sr][sc] = color;
        vis[sr][sc] = true;

        //right
        solve(image, sr, sc+1, color, original_color, vis);
        
        //left
        solve(image, sr, sc-1, color, original_color, vis);
        
        //top
        solve(image, sr-1, sc, color, original_color, vis);
        
        //down
        solve(image, sr+1, sc, color, original_color, vis);
    }
}