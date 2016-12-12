package data_structure;

public class WordSearch {
    
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, word)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word) {
        if (word.isEmpty()) {
            return true;
        }

        if (i < 0 || i >= board.length) {
            return false;
        }
        if (j < 0 || j >= board[i].length) {
            return false;
        }
        
        boolean res = false;
        if (board[i][j] == word.charAt(0)) {
            char c = board[i][j];
            board[i][j] = '#';
            res = (dfs(board, i + 1, j, word.substring(1))
                || dfs(board, i - 1, j, word.substring(1))
                || dfs(board, i, j + 1, word.substring(1))
                || dfs(board, i, j - 1, word.substring(1)));
            board[i][j] = c;
        }
        
        return res;
    }

}
