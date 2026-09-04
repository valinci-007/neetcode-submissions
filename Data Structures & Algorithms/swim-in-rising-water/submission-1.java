class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] minTime = new int[n][n];
        for(int[] row : minTime){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {time, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minTime[0][0] = grid[0][0];
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {
            {0,1},
            {0,-1},
            {1, 0},
            {-1, 0}
        };

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int time = current[0];
            int r = current[1];
            int c = current[2];

            if(time > minTime[r][c]) continue;

            if(r == n-1 && c==n-1) return time;

            for(int[] d : directions){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                int newTime = Math.max(grid[nr][nc], time);
                if(newTime < minTime[nr][nc]){
                    minTime[nr][nc] = newTime;
                    pq.offer(new int[]{newTime, nr, nc});
                }
            } 
        }

        return 0;
    }
}
