class Pair {
    Integer dist;
    Integer index;

    public Pair (int d, int i) {
        this.dist = d;
        this.index = i;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // {dist, index}, custom comparator gives more priority to the greater distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.dist, a.dist));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            pq.offer (new Pair(x*x + y*y, i));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int n = pq.size();
        int res[][] = new int[n][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int co_i = pq.poll().index;
            res[i][0] = points[co_i][0];
            res[i][1] = points[co_i][1];
            i++;
        }

        return res;
    }  
}
