class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                if(grid[r][c]==2){
                    q.add(new int[]{r, c});
                } else if(grid[r][c]==1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int r = q.peek()[0];
                int c = q.peek()[1];
                q.poll();

                for(int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS) continue;
                    if(grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    q.add(new int[]{nr, nc});
                    fresh--;
                }
            }
            time++;
        }

        return fresh==0 ? time - 1 : -1;
    }
}
