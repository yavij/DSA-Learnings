class TrieNode{
    TrieNode[] children;
    boolean isLeaf;

    TrieNode(){
        children = new TrieNode[26];
        isLeaf = false;
    }
}


class WordDictionary {

    private TrieNode root = null;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isLeaf = true;
        
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;

        if (index == word.length()) {
            return node.isLeaf;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            char lower = Character.toLowerCase(c);
            return dfs(word, index + 1, node.children[lower - 'a']);
        }
    }
}
