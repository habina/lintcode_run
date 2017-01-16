package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class WordSuqares {
    
    class TrieNode {
        
        TrieNode[] child;
        boolean isWord;
        char c;
        
        public TrieNode(char c) {
            this.child = new TrieNode[26];
            this.isWord = false;
            this.c = c;
        }
        
        public void addWords(String s) {
            if (s.isEmpty()) {
                this.isWord = true;
                return;
            }
            s = s.toLowerCase();
            char firstChar = s.charAt(0);
            int index = firstChar - 'a';
            if (this.child[index] == null) {
                this.child[index] = new TrieNode(firstChar);
            }
            this.child[index].addWords(s.substring(1));
        }
        
        public boolean containsPrefix(String s) {
            if (s.isEmpty()) {
                return true;
            }
            s = s.toLowerCase();
            int index = s.charAt(0) - 'a';
            if (this.child[index] == null) {
                return false;
            } else {
                return this.child[index].containsPrefix(s.substring(1));
            }
        }
        
        public List<String> getWordByPrefix(String prefix) {
            List<String> res = new ArrayList<String>();
            dfs(res, prefix, "");
            return res;
        }
        
        private void dfs(List<String> res, String prefix, String cur) {
            if (!prefix.isEmpty()) {
                char first = prefix.charAt(0);
                int index = first - 'a';
                if (this.child[index] != null) {
                    this.child[index].dfs(res, prefix.substring(1), cur + first);
                }
            } else {
                if (this.isWord) {
                    res.add(cur);
                }
                for (int i = 0; i < this.child.length; i++) {
                    if (this.child[i] != null) {
                        this.child[i].dfs(res, prefix, cur + this.child[i].c);
                    }
                }
            }
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (words.length == 0) {
            return res;
        }
        
        TrieNode root = new TrieNode(' ');
        for (String word : words) {
            root.addWords(word);
        }
        
        for (String word : words) {
            List<String> cur = new ArrayList<String>();
            cur.add(word);
            dfs(res, cur, root, 1, words);
        }
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> cur, TrieNode root, int level, String[] words) {
        // base case
        if (level == words[0].length()) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        
        // generate the column string
        String prefix = "";
        for (int i = 0; i < level; i++) {
            prefix += cur.get(i).charAt(level);
        }
        
        if (!root.containsPrefix(prefix)) {
            return;
        } else {
            for (String w : root.getWordByPrefix(prefix)) {
                cur.add(w);
                dfs(res, cur, root, level + 1, words);
                cur.remove(cur.size() - 1);
            }
        }
    }

}
