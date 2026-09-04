class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] vis = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for(int r=0; r<rows; r++){
            if(board[r][0]=='O') {
                q.add(new int[]{r, 0});
                vis[r][0] = true;
            }
            if(board[r][cols-1]=='O'){
                q.add(new int[]{r, cols-1});
                vis[r][cols-1] = true;
            }
        }
        for(int c=1; c<cols-1; c++){
            if(board[0][c]=='O'){
                q.add(new int[]{0, c});
                vis[0][c] = true;
            } 
            if(board[rows-1][c]=='O'){
                q.add(new int[]{rows-1, c});
                vis[rows-1][c] = true;
            }
        }

        // for(int i=0; i<rows; i++){
        //     for(int j=0; j<cols; j++){
        //         if(vis[i][j]){
        //             System.out.println("Row : " + i + " Col : " + j);
        //         }
        //     }
        // }

        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
                if(board[nr][nc] == 'X' || vis[nr][nc]) continue;
                q.add(new int[]{nr, nc});
                vis[nr][nc] = true;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
}
