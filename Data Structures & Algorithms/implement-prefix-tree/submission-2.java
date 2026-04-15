class TrieNode{
        TrieNode[] children;
        boolean isLeaf;

        TrieNode(){
            children = new TrieNode[26];
            isLeaf = false;
        }
    }


class PrefixTree {

    TrieNode root = null;

    public PrefixTree() {
       this.root = new TrieNode();  
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
         curr.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}
