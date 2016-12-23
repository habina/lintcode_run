package com.google.phone;

import java.util.HashMap;
import java.util.Map;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    char c;
    boolean isWord;
    Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();
    public TrieNode() {
        this.c = ' ';
        this.isWord = false;
    }
    
    public TrieNode(char c) {
        this.c = c;
        this.isWord = false;
    }
    
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            this.isWord = true;
            return;
        }
        
        char first = word.charAt(0);
        if (!map.containsKey(first)) {
            map.put(first, new TrieNode(first));
        }
        map.get(first).insert(word.substring(1));
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return this.isWord;
        }
        char first = word.charAt(0);
        if (map.containsKey(first)) {
            return map.get(first).search(word.substring(1));
        } else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        char first = prefix.charAt(0);
        if (map.containsKey(first)) {
            return map.get(first).startsWith(prefix.substring(1));
        } else {
            return false;
        }
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix);
    }
}