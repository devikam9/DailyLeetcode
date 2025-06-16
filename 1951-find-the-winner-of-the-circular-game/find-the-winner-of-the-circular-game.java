class Solution {
    public int findTheWinner(int n, int k) {
        //1. keep a list and all the players
        List<Integer> players = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            players.add(i);
        }
        //2. keep the currindex and a count to check if it reaches k
        
        int currIndex = 0;
        //3. iterate the list till list size is equal to 1
        while(players.size() > 1){            

            // 4. use circular list to reset to the beginning index
            int removeIndex = (currIndex + k -1) % players.size();
            //5. remove them from list if they are at k position
            players.remove(removeIndex);
            currIndex = removeIndex;    
        }
        //6. return the first element present in the list
        return players.getFirst();

    }
}