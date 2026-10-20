import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build the Adjacency List (Our Address Book)
        // Maps: Source Server -> List of [Neighbor Server, Travel Time]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];
            
            // If this source server isn't in the book yet, create a blank page
            graph.computeIfAbsent(source, x -> new ArrayList<>()).add(new int[]{destination, travelTime});
        }
        
        // 2. Min-Heap (Our Smart Waiting Line)
        // Keeps tracks of messengers sorted by arrival time: [total_time, server_id]
        // (a, b) -> a[0] - b[0] ensures the shortest absolute time stays at the top
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Send the very first messenger: It takes 0 minutes to be at starting server k
        minHeap.offer(new int[]{0, k});
        
        // 3. Map (Our Golden Clipboard)
        // Maps: Server ID -> Absolute shortest travel time to reach it
        Map<Integer, Integer> visitedTime = new HashMap<>();
        
        // 4. Run the Simulation Loop
        while (!minHeap.isEmpty()) {
            // Grab the messenger arriving earliest across the entire network right now
            int[] current = minHeap.poll();
            int currTime = current[0];
            int currNode = current[1];
            
            // If we have already locked in a time for this server, this messenger is too slow. Skip it!
            if (visitedTime.containsKey(currNode)) {
                continue;
            }
            
            // Because it came from the Min-Heap first, this is officially the fastest possible route to this server.
            // Log it permanently on our clipboard.
            visitedTime.put(currNode, currTime);
            
            // Look up this server's neighbors in our address book
            if (graph.containsKey(currNode)) {
                for (int[] edge : graph.get(currNode)) {
                    int neighbor = edge[0];
                    int weight = edge[1];
                    
                    // If the neighbor hasn't already been finalized on our clipboard, dispatch a new messenger
                    if (!visitedTime.containsKey(neighbor)) {
                        // New time = (Time it took to reach us) + (Time to travel down this specific cable)
                        minHeap.offer(new int[]{currTime + weight, neighbor});
                    }
                }
            }
        }
        
        // 5. Calculate the Final Results
        // If the number of reachable servers logged on our clipboard doesn't equal total servers 'n'
        if (visitedTime.size() != n) {
            return -1; // At least one server was completely cut off
        }
        
        // Scan the clipboard to find the maximum time value
        int maxDelay = 0;
        for (int time : visitedTime.values()) {
            maxDelay = Math.max(maxDelay, time);
        }
        
        // This is the exact second the last server finally received the signal
        return maxDelay;
    }
}
