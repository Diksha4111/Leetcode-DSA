class Solution {
    public boolean isBipartite(int[][] graph) {
        //creating adjacency list 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < graph.length; i ++){
            List<Integer> al = new ArrayList<>();
            for(int j = 0 ; j < graph[i].length; j ++){
                al.add(graph[i][j]);
            }
            adj.add(new ArrayList<>(al));
        }

        int V = graph.length;
        int[] color = new int[V];
        for(int i=0 ; i<V ; i++){
            color[i] = -1;
        }
        //for connected components
        for(int i=0 ; i<V ; i++){
            if(color[i] == -1){
                if(check(i , V , adj , color) == false) return false;
            }
        }
        return true;
    }
    public boolean check(int start , int V , ArrayList<ArrayList<Integer>>adj , int[] color){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            
            for(int adjnode : adj.get(node)){
                //if adjacent node is not coloured
                if(color[adjnode] == -1){
                    color[adjnode] = 1 - color[node];
                    q.offer(adjnode);
                }
                //if the adjacent node is coloured and with the same colour
                else if(color[adjnode] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
