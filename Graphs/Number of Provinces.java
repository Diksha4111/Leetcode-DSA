class Solution {
    public int findCircleNum(int[][] isConnected) {
        /*creating initial configurations for the solution 
        i.e. adj list, visited array amd count*/
        //creating adjacency list
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0 ; i<n ; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        //taking count variable to store number of provinces as answer 
        int count = 0;
        //taking visited array to store node visit information
        boolean[] visited = new boolean[n];

        //counting and traversing provinces
        for(int i=0 ; i<n ; i++){
            if(visited[i] == false){
                count++;
                dfs(i , visited, adj);
            }
        }

        //returning total provinces
        return count;
    }

    //method for performing dfs traversal
    public void dfs(int node, boolean[] visited , ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(int i : adj.get(node)){
            if(visited[i] == false){
                dfs(i , visited , adj);
            }
        }
    }
}
