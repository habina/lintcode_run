package data_structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        Trie trie = new Trie(' ');
        Set<String> set = new HashSet<String>();
        
        for (String s : words) {
            trie.addWord(s);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, trie, set, "");
            }
        }
        
        return new ArrayList<String>(set);
    }
    
    public static void dfs(char[][] b, int i, int j, Trie node, Set<String> res, String cur) {
        if (i < 0 || i >= b.length) {
            return;
        }
        
        if (j < 0 || j >= b[i].length) {
            return;
        }
        
        char c = b[i][j];
        b[i][j] = '#';
        if (node.contains(c)) {
            Trie next = node.get(c);
            if (next.isWord) {
                res.add(cur + c);
            }
            dfs(b, i + 1, j, next, res, new String(cur) + c);
            dfs(b, i - 1, j, next, res, new String(cur) + c);
            dfs(b, i, j + 1, next, res, new String(cur) + c);
            dfs(b, i, j - 1, next, res, new String(cur) + c);
        }
        
        b[i][j] = c;
    }

    public static void main(String[] args) {
        String[] s = {"dog", "dad", "dgdg", "can", "again"};
        ArrayList<String> lst = new ArrayList<String>();
        for (String ss : s) {
            lst.add(ss);
        }
        
        char[][] board = {
            {'d', 'o', 'a', 'f'},
            {'a', 'g', 'a', 'i'},
            {'d', 'c', 'a', 'n'},
        };

        List<String> res = wordSearchII(board, lst);
        
        for (String ss : res) {
            System.out.println(ss);
        }
    }

}
