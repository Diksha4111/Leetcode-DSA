class Solution {
    /* Using DFS */
    public boolean isBipartite(int[][] graph) {
        //creating adjacency list 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < graph.length; i ++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < graph[i].length; j ++){
                list.add(graph[i][j]);
            }
            adj.add(new ArrayList<>(list));
        }

        int V = graph.length;
        int[] color = new int[V];
        for(int i=0 ; i<V ; i++){
            color[i] = -1;
        }
        //for connected components
        for(int i=0 ; i<V ; i++){
            if(color[i] == -1){
                if(dfs(i , 0 , adj , color) == false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node , int col , ArrayList<ArrayList<Integer>>adj , int[] color){
        color[node] = col;
        for(int adjnode : adj.get(node)){
            //if adjacent node is not coloured
            if(color[adjnode] == -1){
                if(dfs(adjnode , 1 - col , adj , color) == false) return false;
            }
            //if the adjacent node is coloured and with the same colour
            else if(color[adjnode] == col){
                return false;
            }
        }
        return true;
    }
}
