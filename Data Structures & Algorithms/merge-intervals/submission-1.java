class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int startTime = intervals[0][0];
        int endTime = intervals[0][1];

        for(int i=1; i<n; i++){
            if(intervals[i][0] <= endTime){
                endTime = Math.max(endTime, intervals[i][1]);
                continue;
            } else {
                res.add(new int[]{startTime, endTime});
                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
        }

        res.add(new int[]{startTime, endTime});
        return res.toArray(new int[res.size()][]);
    }
}
