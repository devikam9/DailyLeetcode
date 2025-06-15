class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        //1. calculate total passengers at each location and add them to new array
        //2. reiterate new array and find at a location current passengers > capacity - return false

        //Tc - O(N + N), Sc - O(1)
        //bcoz constraint given as 1000
        int[] timeLine = new int[1001];
        for(int[] trip : trips){
            int totalPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            //picked at a location
            timeLine[from] += totalPassengers;
            //dropped at a location
            timeLine[to] -= totalPassengers;
        }
        int currentPassengers = 0;
        for(int i = 0; i < timeLine.length; i++){
            currentPassengers += timeLine[i];
            if(currentPassengers > capacity) return false;
        }
        return true;
    }
}