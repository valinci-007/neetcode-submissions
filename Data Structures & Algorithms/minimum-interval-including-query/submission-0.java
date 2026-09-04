class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int minLen = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                int[] interval = intervals[j];
                if(interval[0] > queries[i]) break;
                if(interval[1]>=queries[i]){
                    minLen = Math.min(minLen, interval[1]-interval[0]+1);
                }
            }
            res[i] = minLen == Integer.MAX_VALUE ? -1 : minLen;
        }
        return res;
    }
}
