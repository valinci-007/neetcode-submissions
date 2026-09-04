class Solution {
    private boolean isValidRow(int row, char[][] board){
        Set<Character> hash = new HashSet<>();
        for(int i=0;i<9;i++){
            if(board[row][i] != '.'){
                if(hash.contains(board[row][i])) return false;
                hash.add(board[row][i]);
            }
        }
        return true;
    }

    private boolean isValidCol(int col, char[][] board){
        Set<Character> hash = new HashSet<>();
        for(int i=0;i<9;i++){
            if(board[i][col] != '.'){
                if(hash.contains(board[i][col])) return false;
                hash.add(board[i][col]);
            }
        }
        return true;
    }

    private boolean isValidBox(int box, char[][] board){
        Set<Character> hash = new HashSet<>();

        int row = box/3 * 3;
        int col = box%3 * 3;

        for(int r = row; r<row+3; r++){
            for(int c=col; c<col+3; c++){
                if(board[r][c] != '.'){
                    if(hash.contains(board[r][c])) return false;
                    hash.add(board[r][c]);
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            if(!isValidRow(i, board)) return false;
            if(!isValidCol(i, board)) return false;
            if(!isValidBox(i, board)) return false;
        }
        return true;
    }
}
