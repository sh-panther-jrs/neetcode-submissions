class Node {
    char c;
    Map<Character, Node> children;
    boolean isWord;
    public Node() {
        children = new HashMap<>();
    }
}

class WordDictionary {
    Node root;    
    public WordDictionary() {
        root= new Node();
    }

    public void addWord(String word) {
        addWordHelper(word, 0, root);
    }

    private void addWordHelper(String word, int index, Node node) {
        if(index==word.length()) {
            return;
        }
        char currChar = word.charAt(index);
        node.children.putIfAbsent(currChar, new Node());
        Node child = node.children.get(currChar);
        child.c = currChar;
        if(index==word.length()-1) {
            child.isWord = true;
        } 
        addWordHelper(word, index+1, child);
    }

    public boolean search(String word) {
        return helperSearch(word, 0, root);
    }

    private boolean helperSearch(String word, int index, Node node) {
        if(word.length()==index) {
            return node.isWord;
        }
        char currChar = word.charAt(index);
        if (currChar=='.') {
            for(Node child: node.children.values()) {
                if(helperSearch(word, index+1, child)) {
                    return true;
                }
            }
            return false;
        } else {
                if (node.children.containsKey(currChar)) {
                    return helperSearch(word, index+1, node.children.get(currChar));
                } else {
                    return false;
                }
        }

    }
}
