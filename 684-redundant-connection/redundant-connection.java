import java.util.Arrays;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // The problem states there are N nodes, and the edges array length is N.
        int n = edges.length;
        
        // 1. SETUP THE UNION-FIND LEDGER (Parent Array)
        // We instantiate size n + 1 because the node labels are 1-indexed (numbered 1 to N).
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i; // At the baseline state, every node acts as its own root boss.
        }
        
        // 2. PROCESS EVERY DISPATCHED ROAD LINE-BY-LINE
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            // Ascend the family trees to find the absolute root leader for both nodes
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            
            // THE CYCLE DETECTION TRIGGER:
            // If they already share the exact same root leader, it means a valid path
            // already exists connecting them. Placing this edge creates a redundant loop!
            if (rootU == rootV) {
                return edge; // Return the redundant connection array instantly.
            }
            
            // Otherwise, combine the separate components via a basic Union operation
            parent[rootU] = rootV;
        }
        
        return new int[0]; // Fallback placeholder
    }
    
    // THE FIND ENGINE (With Path Compression)
    private int find(int[] parent, int node) {
        // Base case: If a node maps directly back to itself, it is the ultimate family leader.
        if (parent[node] == node) {
            return node;
        }
        
        // Path Compression: As we climb up recursively to locate the ultimate root,
        // we rewrite parent[node] to point straight to that root. This flattens the tree.
        return parent[node] = find(parent, parent[node]);
    }
}
