/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if(n == 0) return true;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));
        int end = intervals.get(0).end;
        for(int i = 1; i < n; i++){
            if(intervals.get(i).start < end){
                return false;
            } else {
                end = intervals.get(i).end;
            }
        }

        return true;
    }
}
