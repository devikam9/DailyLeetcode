class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        //1. Iterate each cell in the gird. if it's 1 then perform dfs on 4 directions and keep a visited array.
        //2. for every island you note count of area.
        //3. keep a maxArea to find area of all the isalnds
        //4. if maxIsland is present return it, else return 0

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if( visited[i][j] == false && grid[i][j] == 1){
                    int area = dfs(i,j,grid,visited,m,n,0);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int r, int c, int[][] grid, boolean[][] visited, int m, int n, int count){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == 0){
            return 0;
        }
        // count++;
        visited[r][c] = true;
        int[] rows = new int[]{-1,1,0,0};
        int[] cols = new int[]{0,0,-1,1};
        int tempArea = 0;
        for(int i = 0; i < 4; i++){
            int nRow = r + rows[i];
            int nCol = c + cols[i];
            tempArea += dfs(nRow,nCol,grid,visited,m,n,count);
        }
        return tempArea+1;
    }
}