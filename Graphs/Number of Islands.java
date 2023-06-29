//{ Driver Code Starts
// import java.util.*;
// import java.lang.*;
// import java.io.*;
// class GFG {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br =
//             new BufferedReader(new InputStreamReader(System.in));
//         int T = Integer.parseInt(br.readLine().trim());
//         while (T-- > 0) {
//             String[] s = br.readLine().trim().split(" ");
//             int n = Integer.parseInt(s[0]);
//             int m = Integer.parseInt(s[1]);
//             char[][] grid = new char[n][m];
//             for (int i = 0; i < n; i++) {
//                 String[] S = br.readLine().trim().split(" ");
//                 for (int j = 0; j < m; j++) {
//                     grid[i][j] = S[j].charAt(0);
//                 }
//             }
//             Solution obj = new Solution();
//             int ans = obj.numIslands(grid);
//             System.out.println(ans);
//         }
//     }
// }
// } Driver Code Ends



/* BFS Solution */
class Pair{
    int r;
    int c;
    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int row=0 ; row<n ; row++){
            for(int col = 0; col<m ; col++){
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    count++;
                    bfs(row , col , vis , grid);
                }
            }
        }
        return count;
    }
    public void bfs(int row, int col , int[][] vis , char[][] grid){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty()){
            int i = q.peek().r;
            int j = q.peek().c;
            q.remove();
            for(int delrow = -1 ; delrow<=1 ; delrow++){
                for(int delcol = -1; delcol<=1 ; delcol++){
                    int nrow = i + delrow;
                    int ncol = j + delcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        vis[nrow][ncol] = 1;
                        q.offer(new Pair(nrow , ncol));
                    }
                }
            }
        }
    }
}


/* DFS solution */
class Solution{
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int row=0 ; row<n ; row++){
            for(int col = 0; col<m ; col++){
                if(grid[row][col] == '1'){
                    count++;
                    dfs(row , col , grid);
                }
            }
        }
        return count;
    }
    public void dfs(int row, int col, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if(row>=0 && row<n && col>=0 && col<m && grid[row][col] == '1'){
            grid[row][col] = '0';
            dfs(row , col+1, grid);
            dfs(row , col-1, grid);
            dfs(row-1 , col, grid);
            dfs(row+1 , col, grid);
        }
    }
}
