class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotTom = new LinkedList<>();
        int row = grid.length, col = grid[0].length, freshTomatoes = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    rotTom.add(new int[]{i,j});
                } else if(grid[i][j] == 1){
                    freshTomatoes++;
                }
                
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes = -1;
        while(!rotTom.isEmpty()){
            int size = rotTom.size();
            for(int i = 0; i < size; i++){
                int[] values = rotTom.remove();
                int ro = values[0];
                int co = values[1];

                for(int[] dir : dirs){
                    int r = ro + dir[0];
                    int c = co + dir[1];

                    if( r >= 0 && c >= 0 && r < row && c < col){
                        if(grid[r][c] == 1){
                            grid[r][c] = 2;
                            rotTom.add(new int[]{r,c});
                            freshTomatoes--;
                        }
                    }
                }    
            }
            minutes++;
        }
        if(minutes == -1 && freshTomatoes == 0) return 0;
        return freshTomatoes == 0 ? minutes : -1;    
    }
}