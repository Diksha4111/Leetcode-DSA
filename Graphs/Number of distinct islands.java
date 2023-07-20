class Solution {
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        //traverse through the grid
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    //create new arraylist for each island
                    ArrayList<String> list = new ArrayList<String>();
                    //call dfs if found land that is unvisited
                    dfs(i , j , vis , grid , list , i , j);
                    //add the list into the set
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    
    //method to convert integer to string so as to enter in the list
    public String toString(int row , int col){
        return Integer.toString(row) + " " + Integer.toString(col);
    }
    
    //method for dfs traversal
    public void dfs(int row , int col , int[][] vis , int[][] grid , 
    ArrayList<String> list , int srow , int scol){
        //mark the reached land as visited
        vis[row][col] = 1;
        //add its coordinates as string in the list
        list.add(toString(row - srow , col - scol));
        int n = grid.length;
        int m = grid[0].length;
        //calculate the net difference of the indices of row and col in 4 directions
        int[] delrow = {-1 , 0 , 1 , 0};
        int[] delcol = {0 , 1 , 0 , -1};
        //traverse in 4 directions
        for(int i=0 ; i<4 ; i++){
            //calculate new row and new col index
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            //call dfs if new indices are valid(within the grid) 
            //and you have reached a land that is unvisited
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
            && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                dfs(nrow , ncol , vis , grid , list , srow , scol);
            }
        }
    }
}
