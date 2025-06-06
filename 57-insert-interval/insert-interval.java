class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        //1. check if newInterval.start > intervals.end -> non overlapping
        //2. check if newInterval.end > intervals.start -> overlapping
        //3. take in a data structure - min of 2 starts = start
        //4. max of 2 ends = end
        //5. return the result.


        List<int[]> result = new ArrayList<>();

        int i = 0;

        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i = i+1;
        }

        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i = i + 1;
        }
        result.add(newInterval);

        while(i < intervals.length){
            result.add(intervals[i]);
            i = i+1;
        }

        return result.toArray(new int[result.size()][]);
        
    }
}