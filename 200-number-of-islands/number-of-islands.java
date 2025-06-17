class Solution {

    //Tc - O(M * N), Sc - O(M * N)
    public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int islands = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == false && grid[i][j] == '1'){
                    
                    dfs(grid,vis,i,j);
                    islands++;
                }
            }
        }
        return islands;    
    }

    public void dfs(char[][] grid,boolean[][] vis,int row,int col){

        if(row < 0 || col < 0 || row >= grid.length ||  col >= grid[0].length || grid[row][col] == '0' || vis[row][col] == true){
            return;
        }

        vis[row][col] = true;
        
        dfs(grid,vis,row-1,col);
        dfs(grid,vis,row+1,col);
        dfs(grid,vis,row,col+1);
        dfs(grid,vis,row,col-1);
    }
}