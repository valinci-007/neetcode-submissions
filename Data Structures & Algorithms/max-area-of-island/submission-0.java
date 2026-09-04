class Solution {
    int ROWS;
    int COLS;
    int area;

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean isValidCell(int row, int col){
        return !(row < 0 || col < 0 || row >= ROWS || col >= COLS);
    }

    private void dfs(int r, int c, int[][] grid){
        grid[r][c] = 0;
        this.area++;

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(isValidCell(nr, nc) && grid[nr][nc] == 1){
                dfs(nr, nc, grid);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.ROWS = grid.length;
        this.COLS = grid[0].length;

        int maxArea = 0;

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                if(grid[r][c] == 1){
                    this.area = 0;
                    dfs(r, c, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
