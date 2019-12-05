package array;

public class GameOfLife {
    private int[] xDirection = {-1, 0, 1, -1, 1, -1, 0 ,1};
    private int[] yDirection = {1, 1, 1, 0, 0, -1, -1, -1};
    private static final int LIVE_TO_DEAD = -2;
    private static final int DEAD_TO_LIVE = -1;

    public void gameOfLife(int[][] board) {

        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                liveAndDeadOperation(board, i, j);
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == LIVE_TO_DEAD){
                    board[i][j] = 0;
                }else if(board[i][j] == DEAD_TO_LIVE){
                    board[i][j] = 1;
                }
            }
        }
    }
    private void liveAndDeadOperation(int[][] board, int x, int y){
        int liveNum = 0;
        for(int i = 0; i < xDirection.length; i++){
            int newX = x + xDirection[i];
            int newY = y + yDirection[i];
            if(!isValid(board, newX, newY)){
                continue;
            }
            if(board[newX][newY] == 1 || board[newX][newY] == LIVE_TO_DEAD){
                liveNum++;
            }
        }
        if(board[x][y] == 1 && (liveNum < 2 || liveNum > 3)){
            board[x][y] = LIVE_TO_DEAD;
        }
        if(board[x][y] == 0 && liveNum == 3){
            board[x][y] = DEAD_TO_LIVE;
        }
    }

    private boolean isValid(int[][] board, int newX, int newY){
        if(newX >= 0 && newX < board.length && newY >=0 && newY < board[0].length){
            return true;
        }
        return false;
    }
}
