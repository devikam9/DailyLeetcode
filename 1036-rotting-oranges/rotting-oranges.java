class Solution {
    public int orangesRotting(int[][] grid) {
        // you need to start exploding from all the 2's at a time - so BFS is best

        //add all the fruits to queue and use level in queue

        // if(grid[0][0] == 0) return 0;

        Queue<Pair> que = new LinkedList<>();
        int freshCount = 0, timeToRotten = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    que.add(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        int[] rows = new int[]{-1,+1,0,0};
        int[] cols = new int[]{0,0,-1,+1};

        while(!que.isEmpty()){
            int level = que.size();

            for(int j = 0; j < level; j++){
                Pair ele = que.remove();
                int row = ele.first;
                int col = ele.second;


                for(int i = 0; i < 4; i++){
                int nRow = row + rows[i];
                    int nCol = col + cols[i];

                    if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1){
                        grid[nRow][nCol] = 2;
                        que.add(new Pair(nRow,nCol));
                        freshCount--;
                    }
                }
            }

            timeToRotten++;  
        }
        if(timeToRotten == -1 && freshCount == 0) return 0;
        return freshCount == 0 ? timeToRotten : -1;
    }

    
}

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}