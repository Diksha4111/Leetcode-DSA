//using BFS
class Pair{
    int row, col;
    public Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        //checking boundary to find 1's
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j] == 1){
                        q.offer(new Pair(i,j));
                        vis[i][j] = true;
                    }
                }
            }
        }
        
        int[] delrow = {-1 , 0 , 1 , 0};
        int[] delcol = {0 , 1 , 0 , -1};
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            //checking in all 4 directions to find 1
            for(int i=0 ; i<4 ; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                && grid[nrow][ncol] == 1 && vis[nrow][ncol] == false){
                    q.offer(new Pair(nrow , ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
        
        //finding total number of enclaves
        int numberOfEnclaves = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    numberOfEnclaves++;
                }
            }
        }
        return numberOfEnclaves;
    }
}
