class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        // 'curr' represents the parent node we are standing on in the current row
        Node curr = root;
        
        // This loop runs as long as there is another level below to process
        while (curr != null) {
            
            // Create a fake placeholder node to mark the start of the next row down
            Node dummy = new Node(0);
            // 'tail' will stitch the next row's nodes together
            Node tail = dummy;
            
            // Walk horizontally across the current row using the .next pointers
            while (curr != null) {
                // If the current parent has a left child, link it!
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next; // Move our needle forward
                }
                // If the current parent has a right child, link it!
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next; // Move our needle forward
                }
                
                // Step to the right to the next parent in the same row
                curr = curr.next;
            }
            
            // Once the row is finished, drop down to the start of the next row.
            // 'dummy.next' holds the actual first real child of this level.
            curr = dummy.next;
        }
        
        return root;
    }
}
