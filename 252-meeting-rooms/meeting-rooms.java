class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
// the start of the next meeting is before the end of the current one, it means they overlap 
        for(int i = 0; i < intervals.length - 1; i++){    
                if(intervals[i+1][0] < intervals[i][1]){
                    return false;
                }    
        }
        return true;
        
    }
}