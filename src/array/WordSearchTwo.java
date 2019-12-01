package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchTwo {
    private static final int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0 || board[0].length == 0){
            return new ArrayList();
        }
        if(words.length == 0){
            return new ArrayList();
        }
        HashSet<String> set = new HashSet<>();
        int row = board.length;
        int col = board[0].length;
        for(String word : words){
            boolean[][] marked = new boolean[row][col];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(dfs(board, marked, i, j, 0, word)){
                        set.add(word);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
    private boolean dfs(char[][] board, boolean[][] marked, int i, int j, int startIndex, String word){
        if(startIndex == word.length() - 1){
            return word.charAt(word.length() - 1) == board[i][j];
        }
        if(word.charAt(startIndex) == board[i][j] && !marked[i][j]){
            marked[i][j] = true;
            for(int k = 0; k < 4; k++){
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if(inArea(newX, newY, board.length, board[0].length) && !marked[newX][newY] && dfs(board, marked, newX, newY, startIndex + 1 ,word)){
                    return true;
                }
            }
            marked[i][j] = false;
        }
        return false;
    }


    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
