class TrieNode{
    TrieNode[] children;
    String word;

    TrieNode(){
        children = new TrieNode[26];
        word = null;
    }
}

class Solution {

    private List<String> results = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(trie, board, i, j);
            }
        }
        return results;
    }

    private void dfs(TrieNode node, char[][] board,int i, int j){
        char c = board[i][j];

        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c-'a'];

         if (node.word != null) {
            results.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        int[] dirs = {0, 1, 0, -1, 0};
        for (int d = 0; d < 4; d++) {
            int ni = i + dirs[d];
            int nj = j + dirs[d + 1];

            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length) {
                dfs(node, board, ni, nj);
            }
        }

        board[i][j] = c; // backtrack
    } 

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode curr = root;
                for(char c: word.toCharArray()){
                    int index = c-'a';
                    if(curr.children[index]==null){
                        curr.children[index] = new TrieNode();
                    }
                    curr = curr.children[index];
                }
            curr.word = word;
        }
        return root;
    }
}
