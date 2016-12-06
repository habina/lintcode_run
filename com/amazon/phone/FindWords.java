package com.amazon.phone;

public class FindWords {
    
    public static void findWords(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            dfs(m, i, 0, "");
            dfs2(m, 0, i, "");
        }
    }
    
    public static void dfs2(char[][] m, int i, int j, String cur) {
        System.out.println(cur);

        if (i >= m.length) {
            return;
        }
        
        if (j >= m[i].length) {
            return;
        }
        
        for (int z = i; z < m.length; z++) {
            cur += m[z][j];
            dfs2(m, z + 1, j, cur);
            cur = cur.substring(0, cur.length() - 1);
        }
        
    }
    
    public static void dfs(char[][] m, int i, int j, String cur) {
        System.out.println(cur);

        if (i >= m.length) {
            return;
        }
        
        if (j >= m[i].length) {
            return;
        }

        for (int z = j; z < m.length; z++) {
            cur += m[i][z];
            dfs(m, i, z + 1, cur);
            cur = cur.substring(0, cur.length() - 1);
        }
        
    }

    public static void main(String[] args) {
        char[][] m = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        
        findWords(m);
    }

}
