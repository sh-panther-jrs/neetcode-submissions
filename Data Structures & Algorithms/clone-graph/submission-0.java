/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> nodeStore = new HashMap<>();
        return cloneGraphHelper(node, nodeStore);
    }

    private Node cloneGraphHelper(Node node, Map<Integer, Node> nodeStore) {
        if (node==null) {
            return null;
        }
        if (nodeStore.containsKey(node.val)) {
            return nodeStore.get(node.val);
        }
        Node clonedNode = new Node();
        clonedNode.val = node.val;
        List<Node> neighborsCloned = new ArrayList<>();
        nodeStore.put(node.val, clonedNode);
        for(Node neighbor: node.neighbors) {
            neighborsCloned.add(cloneGraphHelper(neighbor, nodeStore));
            
        }
        clonedNode.neighbors = neighborsCloned;
        
        return clonedNode;
    }
}