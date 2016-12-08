package data_structure;

public class TrieTest {
    
    public static void main(String[] args) {
        Trie root = new Trie('0');
        
        root.addWord("tree");
        root.addWord("trie");
        root.addWord("algo");
        root.addWord("assoc");
        root.addWord("all");
        root.addWord("also");
        
        System.out.println(root);
        System.out.println(root.contains("alg"));
        System.out.println(root.contains("algo"));
        System.out.println(root.remove("algo"));
        System.out.println(root);
    }
    
}
