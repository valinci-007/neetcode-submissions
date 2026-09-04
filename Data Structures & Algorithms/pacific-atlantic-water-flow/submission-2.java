
class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();

        // Add Pacific border cells
        // Left column
        for (int r = 0; r < rows; r++) {
            pacificQueue.add(new int[]{r, 0});
            pacific[r][0] = true;
        }

        // Top row
        for (int c = 1; c < cols; c++) {
            pacificQueue.add(new int[]{0, c});
            pacific[0][c] = true;
        }

        // Add Atlantic border cells
        // Right column
        for (int r = 0; r < rows; r++) {
            atlanticQueue.add(new int[]{r, cols - 1});
            atlantic[r][cols - 1] = true;
        }

        // Bottom row
        for (int c = 0; c < cols - 1; c++) {
            atlanticQueue.add(new int[]{rows - 1, c});
            atlantic[rows - 1][c] = true;
        }

        // Reverse BFS from both oceans
        bfs(pacificQueue, heights, pacific, dirs);
        bfs(atlanticQueue, heights, atlantic, dirs);

        // Cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(
        Queue<int[]> queue,
        int[][] heights,
        boolean[][] visited,
        int[][] dirs
    ) {
        int rows = heights.length;
        int cols = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Out of bounds
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                // Already reachable from this ocean
                if (visited[nr][nc]) {
                    continue;
                }

                // Reverse flow:
                // We can move only to equal or higher cells
                if (heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}