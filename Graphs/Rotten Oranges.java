class Pair{
    int row; 
    int col;
    int t;
    public Pair(int row , int col , int t){
        this.row = row;
        this.col = col;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        int fresh = 0;
        //to find out rotten oranges 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                //adding rotten oranges in the queue
                if(grid[i][j] == 2){
                    q.offer(new Pair(i , j , 0));
                    vis[i][j] = 2;
                }
                //keeping track of the fresh oranges
                else if(grid[i][j] == 1) fresh++;
                else vis[i][j] = 0;
            }
        }

        int time = 0 , count = 0;
        //net change in row,col indices
        int[] delrow = {1 , 0 , -1 , 0};
        int[] delcol = {0 , 1 , 0 , -1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int t = q.peek().t;
            q.remove();
            //compute max time
            time = Math.max(time , t);
            for(int i = 0 ; i < 4 ; i++){
                //calculate new indices of neighbour oranges
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                //check necessary condition for an orange to get rotten
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 2){
                    //if found fresh unvisited orange then add it in queue and make it rotten in the visited matrix
                    q.offer(new Pair(nrow , ncol , time+1));
                    vis[nrow][ncol] = 2;
                    //keeping track of how many oranges have been rotten
                    count++;
                }
            }
        }

        //if fresh oranges that have been rotten are not equal to the total fresh oranges 
        //then return -1, otherwise return computed max time.
        if(count != fresh) return -1; 

        return time;
    }
}
