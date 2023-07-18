class Tuple{
    int row;
    int col;
    int dist;
    public Tuple(int row, int col , int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] distance = new int[n][m];
        Queue<Tuple> q = new LinkedList<Tuple>();
        //finding 1's
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j] == 1){
                    vis[i][j] = 1;
                    q.offer(new Tuple(i , j , 0));
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        
        //net row,col indices difference
        int[] delrow = {-1 , 0 , 1 , 0};
        int[] delcol = {0 , 1 , 0 , -1};
        
        //calculating answer distance matrix
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;
            q.poll();
            distance[row][col] = dist;
            //calculating in all 4 directions of every node 
            for(int i=0 ; i<4 ; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.offer(new Tuple(nrow , ncol , dist+1));
                }
                
            }
        }
        return distance;
    }
}
