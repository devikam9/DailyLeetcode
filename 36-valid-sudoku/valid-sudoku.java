class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Tc - O(N * N), Sc - O(N * N)
       HashSet<String> set = new HashSet<>();


       for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
            int currChar = board[i][j];
            if(currChar != '.'){
                if(!set.add(currChar + "is in row" + i) || !set.add(currChar + "is in column" + j) || 
                !set.add(currChar + "is in location" + (i/3) + (j/3))){
                    return false;
                }
            }     
        }
       }
       return true;    
    }
}
