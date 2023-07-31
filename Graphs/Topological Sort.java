class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0 ; i<V ; i++){
            if(vis[i] == 0){
                dfs(i , vis , st , adj);
            }
        }
        
        int[] ans = new int[V];
        int i=0;
        while(!st.isEmpty()){
            ans[i] = st.peek();
            st.pop();
            i++;
        }
        
        return ans;
    }
    public static void dfs(int node , int[] vis , Stack<Integer> st , ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        
        for(int adjnode : adj.get(node)){
            if(vis[adjnode] == 0){
                dfs(adjnode , vis , st , adj);
            }
        }
        
        st.push(node);
    }
}
