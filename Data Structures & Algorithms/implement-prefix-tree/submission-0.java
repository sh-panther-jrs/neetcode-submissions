class TrieNode {
    char character;
    Map<Character, TrieNode> children;
    List<String> cachedWords;
    public TrieNode() {
        children=new HashMap<>();
        cachedWords = new ArrayList<>();
    }
    public TrieNode(char c) {
        this.character=c;
        this.children=new HashMap<>();
        this.cachedWords = new ArrayList<>();
    }
}

class PrefixTree {

    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        helper(root, word.toCharArray(), 0);
    }

    private void helper(TrieNode root, char[]word, int index){
        if(index==word.length) {
            root.cachedWords.add(new String(word));
            return;
        }
        if (!root.children.containsKey(word[index])) {
            TrieNode charNode = new TrieNode(word[index]);
            root.children.put(word[index], charNode);
        } 
        helper(root.children.get(word[index]), word, index+1);
    }

    public boolean search(String word) {
        return helperSearch(root, word.toCharArray(), 0);
    }

    private boolean helperSearch(TrieNode root, char[]word, int index) {
        if (word.length==index) {
            return root.cachedWords.contains(new String(word));
        }
        if (!root.children.containsKey(word[index])) {
            return false;
        }
        return helperSearch(root.children.get(word[index]), word, index+1);
    }

    private boolean helperStartsWithSearch(TrieNode root, char[]word, int index) {
        if (word.length==index) {
            return true;
        }
        if (!root.children.containsKey(word[index])) {
            return false;
        }
        return helperStartsWithSearch(root.children.get(word[index]), word, index+1);
    }

    public boolean startsWith(String prefix) {
        return helperStartsWithSearch(root, prefix.toCharArray(), 0);
    }
}