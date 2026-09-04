class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> res = new ArrayList<>();
        // Phase 1: intervals entirely before newInterval (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }


        // Phase 2: merge all intervals overlapping newInterval
        int startTime = newInterval[0];
        int endTime = newInterval[1];
        while (i < n && intervals[i][0] <= endTime) {
            startTime = Math.min(startTime, intervals[i][0]);
            endTime = Math.max(endTime, intervals[i][1]);
            i++;
        }
        res.add(new int[]{startTime, endTime});

        // Phase 3: intervals entirely after the merged interval
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
