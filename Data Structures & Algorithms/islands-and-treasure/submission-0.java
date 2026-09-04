class Solution {
    public void islandsAndTreasure(int[][] grid) {
        final int INF = Integer.MAX_VALUE;
        int rows = grid.length, cols = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (grid[r][c] == 0) q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
                if (grid[nr][nc] != INF) continue;      // wall (-1), gate (0), or already set
                grid[nr][nc] = grid[r][c] + 1;           // mark on first reach
                q.offer(new int[]{nr, nc});
            }
        }
    }
}