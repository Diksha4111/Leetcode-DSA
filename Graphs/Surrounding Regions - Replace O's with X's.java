class Solution {
    public void solve(char[][] board) {
        int[] delrow = {-1 , 0 , 1 , 0};
        int[] delcol = {0 , 1 , 0 , -1};
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        
        //find O's in first and last row and mark them visited
        for(int j=0 ; j<m ; j++){
            //first row
            if(board[0][j] == 'O' && vis[0][j] == 0){
                dfs(0 , j , vis , board , delrow , delcol);
            }
            //last row
            if(board[n-1][j] == 'O' && vis[n-1][j] == 0){
                dfs(n-1 , j , vis , board , delrow , delcol);
            }
        }
        //find O's in first and last column and mark them visited
        for(int i=0 ; i<n ; i++){
            //first column
            if(board[i][0] == 'O' && vis[i][0] == 0){
                dfs(i , 0 , vis , board , delrow , delcol);
            }
            //last column
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0){
                dfs(i , m-1 , vis , board , delrow , delcol);
            }
        }
        //convert remaining O's to X's
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(board[i][j] == 'O' && vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int row , int col , int[][] vis,
    char[][] mat , int[] delrow , int[] delcol){
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i=0 ; i<4 ; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i]; 
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
            && mat[nrow][ncol] == 'O' && vis[nrow][ncol] == 0){
                dfs(nrow , ncol , vis , mat , delrow , delcol);
            }
        }
    }
}
