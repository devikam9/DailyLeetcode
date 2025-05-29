class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    List<String> buffer = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // 1.create a col set, positivediag, negdiag sets.
        //2. if they dont contain - add Q to it
        //3. return the list and mark it to . again.
        char[][] board = new char[n][n];
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

       helper(board,0,0,sb,n); 

       return result;    
    }

    private void helper(char[][] board, int row, int column,StringBuffer sb,int size){
        //oobs
        if(row < 0 || row > size){
            return;
        }

        if(row == size){
            
            List<String> list = new ArrayList<>();
            for(char[] r : board){
                list.add(new String(r));
            }
            result.add(list);
            return;
        }
        sb = new StringBuffer(); 
        for(int col = 0; col < size; col++){
            
            if(!cols.contains(col) && !posDiag.contains(row + col) && !negDiag.contains(row - col)){
                cols.add(col);//0,2
                posDiag.add(row + col);//0,3
                negDiag.add(row -col);//0,-1
                board[row][col] = 'Q';//[q]
                helper(board,row+1,col,sb,size);
                cols.remove(col);
                posDiag.remove(row + col); 
                negDiag.remove(row -col);
                board[row][col] = '.'; //1-[.,.]   
            }   
        }
        
        
        


    }
}