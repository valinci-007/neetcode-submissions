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
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if(n==0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        pq.offer(intervals.get(0).end);
        int ans = 1;
        for(int i=1; i<n; i++){
            Interval interval = intervals.get(i);
            if(pq.peek() <= interval.start){
                pq.poll();
            }
            pq.offer(interval.end);
        }
        return pq.size();
    }
}
