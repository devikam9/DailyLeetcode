class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {

        dp = new int[grid.length][grid[0].length];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return helper(grid,0,0);
        
    }

    private int helper(int[][] grid, int row, int col){

        if(row >= grid.length || col >= grid[0].length)
            return Integer.MAX_VALUE;
        if(row == grid.length - 1 && col == grid[0].length - 1) 
            return grid[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int down = helper(grid,row+1,col);
        if(down != Integer.MAX_VALUE)
            down += grid[row][col];

        int right = helper(grid,row,col+1);
        if(right != Integer.MAX_VALUE)
            right += grid[row][col]; 

        return dp[row][col] = Math.min(right,down);
    }
}