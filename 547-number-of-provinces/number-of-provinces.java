class Solution {
    public int findCircleNum(int[][] isConnected) {

        //given adj matrix - find len to get total no of nodes

        int n = isConnected.length;
        //create a visited array
        boolean[] vis = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                provinces++;
                dfs(i,isConnected,vis);
            }
        }

        return provinces;
    }

    private void dfs(int node,int[][] isConnected,boolean[] vis){
        vis[node] = true;

        for(int i = 1; i < isConnected[0].length; i++){
            if(!vis[i] && isConnected[node][i] == 1){
                dfs(i,isConnected,vis);
            }
        }
    }
}