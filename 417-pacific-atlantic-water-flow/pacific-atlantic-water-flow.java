import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        // Ledger matrices to track which cells can reach each ocean
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];
        
        // 1. CHOOSE MULTI-SOURCE BOUNDARY POINTS
        // Loop through columns (Top edge for Pacific, Bottom edge for Atlantic)
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, Integer.MIN_VALUE, pacificReachable); // Top
            dfs(heights, rows - 1, c, Integer.MIN_VALUE, atlanticReachable); // Bottom
        }
        
        // Loop through rows (Left edge for Pacific, Right edge for Atlantic)
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, Integer.MIN_VALUE, pacificReachable); // Left
            dfs(heights, r, cols - 1, Integer.MIN_VALUE, atlanticReachable); // Right
        }
        
        // 2. INTERSECT THE RESULTS
        // Find every cell where water can flow to both destinations
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, int r, int c, int prevHeight, boolean[][] reachable) {
        // 3. BACKWARD BOUNDARY & SLOPE CHECK (The Firewall)
        // Stop if out of bounds, already visited, or if the land slopes downwards backwards
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || reachable[r][c]) {
            return;
        }
        if (heights[r][c] < prevHeight) {
            return; // Moving backwards up the mountain requires heights[r][c] >= prevHeight
        }
        
        // Mark this cell as reachable from the starting ocean source
        reachable[r][c] = true;
        
        // Radiate out in 4 directions to continue climbing up the grid terrain
        dfs(heights, r + 1, c, heights[r][c], reachable); // Down
        dfs(heights, r - 1, c, heights[r][c], reachable); // Up
        dfs(heights, r, c + 1, heights[r][c], reachable); // Right
        dfs(heights, r, c - 1, heights[r][c], reachable); // Left
    }
}
