class Solution {
    public int countComponents(int n, int[][] edges) {

        //create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            // List<Integer> list = new ArrayList<>();
            // adj.get(i).add(list);
            adj.add(new ArrayList<>());
        }
        for(int[] it : edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }

        //count unconnected components
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;

        for(int it : adj.get(node)){
            if(vis[it] == false){
                dfs(it,adj,vis);
            }
        }
    }
}