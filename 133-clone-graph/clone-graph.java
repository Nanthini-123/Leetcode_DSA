/*
// Definition for a Node.
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

import java.util.*;

class Solution {
    // Our Golden Clipboard: Maps Original Node -> Cloned Node
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        // Base case: If the input graph is empty, return null
        if (node == null) {
            return null;
        }

        // Check Clipboard: If we already cloned this node before, just return its replica
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 1. Create a deep copy clone of the current node (with a blank list of neighbors)
        Node cloneNode = new Node(node.val, new ArrayList<>());
        
        // 2. Log it on our clipboard permanently
        visited.put(node, cloneNode);

        // 3. Look at all the neighbors of the original node and clone them
        for (Node neighbor : node.neighbors) {
            // Recursively clone the neighbor and add it to our clone's neighbor list
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        // Return the fully cloned graph starting node
        return cloneNode;
    }
}
