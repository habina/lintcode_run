package com.google.phone;

public class WordDictionary {

    public class Trie {

        char val;
        Trie[] child;
        boolean isWord;

        public Trie(char val) {
            this.child = new Trie[26];
            this.val = val;
            this.isWord = false;
        }

        public void addWord(String s) {
            if (s.isEmpty()) {
                this.isWord = true;
                return;
            }
            char first = s.charAt(0);
            int index = first - 'a';
            if (child[index] == null) {
                this.child[index] = new Trie(first);
            }
            this.child[index].addWord(s.substring(1));
        }

        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return this.isWord;
            }

            char first = word.charAt(0);
            if (first == '.') {
                for (int i = 0; i < 26; i++) {
                    if (this.child[i] != null) {
                        if (this.child[i].search(word.substring(1))) {
                            return true;
                        }
                    }
                }
            } else {
                int index = first - 'a';
                if (child[index] != null) {
                    return this.child[index].search(word.substring(1));
                }
            }
            return false;
        }

    }

    Trie root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.addWord(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the
     * dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return root.search(word);
    }
}