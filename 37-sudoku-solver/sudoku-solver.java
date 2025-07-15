class Solution {
    public void solveSudoku(char[][] board) {
        
    //iterate board and find
        //1. if it exists in row
        //2. if it exists in col
        //3. if it exists in the 3 * 3 matrix. 
        // then return true else false

        solveSodoku(board);
    }

    private boolean solveSodoku(char[][] board){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(board[i][j] == '.'){
                    for(char ch = '1' ; ch <= '9'; ch++){
                        if(isValid(board,i,j,ch) == true){
                            board[i][j] = ch;

                            if(solveSodoku(board) == true)
                                return true;
                            else
                               board[i][j] = '.'; 
                        }
                    }
                    //if you can't place any char then return false
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch){
        for(int i = 0; i < 9; i++){

            if(board[row][i] == ch){
                return false;
            }

            if(board[i][col] == ch){
                return false;
            }

            if(board[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] == ch){
                return false;
            }
        }
        return true;
    }
}