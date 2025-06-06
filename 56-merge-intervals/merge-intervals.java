class Solution {
    public int[][] merge(int[][] intervals) {
        // ask qstn - whether they are sorted or not - sort on start time

        //1. if intervals[i][end] < intervals[i][start] -> non -overlapping
        //2. if intervals[i][end] > intervals[i][start] -> overlap
        //3. if overlaps then min of all the starts
        //4. if overlaps then max of all the ends

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals){
            if(i[0] <= end){
                start = Math.min(i[0],start);
                end = Math.max(i[1],end);
            }else{
                result.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }
        result.add(new int[]{start,end});

        return result.toArray(new int[result.size()][]);
    
    }
}