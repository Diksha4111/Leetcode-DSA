class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans_img = image;
        int iniColor = image[sr][sc];
        //net change in row and column index in 4 directions
        int[] delrow = {+1 , 0 , -1 , 0};
        int[] delcol = {0 , +1 , 0 , -1};
        dfs(sr , sc , image , ans_img , delrow , delcol , color , iniColor);
        //eturning new updated image
        return ans_img; 
    }
    public void dfs(int row , int col , int[][] image , 
    int[][] ans_img , int[] delrow , int[] delcol , int color , int iniColor){
        //colouring the pixel for which dfs is called
        ans_img[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        //running loop 4 times because dfs will check each pixel's neighbours in 4 directions
        for(int i=0 ; i<4 ; i++){
            //calculating new pixel indices
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            //checking all conditions  to fill the neighbour pixeles with the same color
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
            && image[nrow][ncol] == iniColor && ans_img[nrow][ncol] != color){
                dfs(nrow , ncol , image , ans_img , delrow , delcol , color , iniColor);
            } 
        }
    }
}
