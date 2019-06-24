import Trie.Trie;

public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true



    }
}
