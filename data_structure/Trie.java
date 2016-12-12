package data_structure;

public class Trie {
    
    char cur;
    Trie[] nodes;
    boolean isWord;
    int numNodes;
    int level;
    
    public Trie(char c) {
        cur = c;
        nodes = new Trie[26];
        for (int i = 0; i < 26; i++) {
            nodes[i] = null;
        }
        isWord = false;
        numNodes = 0;
        level = 0;
    }

    public Trie(char c, int level) {
        this(c);
        this.level = level + 1;
    }
    
    public void addWord(String word) {
        if (contains(word)) {
            return;
        }
        if (word.isEmpty()) {
            this.isWord = true;
            return;
        }

        word = word.toLowerCase();
        char first = word.charAt(0);
        int index = first - 97;
        
        if (nodes[index] == null) {
            numNodes++;
            nodes[index] = new Trie(first, this.level);
        }

        nodes[index].addWord(word.substring(1));
    }
    
    public boolean contains(String word) {
        if (word.isEmpty()) {
            return this.isWord;
        }
        
        word = word.toLowerCase();
        char first = word.charAt(0);
        int index = first - 97;

        if (nodes[index] == null) {
            return false;
        } else {
            return nodes[index].contains(word.substring(1));
        }
    }
    
    public boolean contains(char c) {
        if (c < 97 || c > 122) {
            return false;
        }
        return nodes[c - 97] != null;
    }
    
    public Trie get(char c) {
        if (contains(c)) {
            return nodes[c - 97];
        }
        return null;
    }
    
    public boolean remove(String word) {
        if (!contains(word)) {
            return false;
        }
        
        if (word.isEmpty()) {
            return numNodes == 0;
        }
        
        word = word.toLowerCase();
        char first = word.charAt(0);
        int index = first - 97;
        
        if (nodes[index] != null) {
            if (nodes[index].remove(word.substring(1))) {
                numNodes--;
                nodes[index] = null;
                return numNodes == 0;
            }
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        String out = this.cur + "\n";
        for (Trie node : nodes) {
            if (node != null) {
                for (int i = 0; i <= level; i++) {
                    out += "--";
                }
                out += node.toString();
            }
        }
        
        return out;
    }

}
