import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. BUILD THE GRAPH & INDEGREE DICTIONARY
        // adjList maps: Prerequisite Course -> List of Next Dependent Courses
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // inDegree[i] tracks how many prerequisites Course i currently has remaining
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adjList.get(prerequisite).add(course); // Directed road: Prereq -> Course
            inDegree[course]++; // One more arrow pointing into this course
        }
        
        // 2. FIND STARTING COURSES (No Prerequisites Needed)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i); // Safe to take on Day 1!
            }
        }
        
        // 3. THE SIMULATION / PROCESSING ENGINE
        int[] order = new int[numCourses];
        int index = 0; // Tracks our position inside our graduation schedule array
        
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            order[index++] = currCourse; // Take the course and add it to our graduation timeline
            
            // Look at all subsequent courses that depended on this completed course
            for (int nextCourse : adjList.get(currCourse)) {
                inDegree[nextCourse]--; // We completed a prerequisite! Drop its count by 1
                
                // If it now has 0 remaining prerequisites, it is officially unlocked
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // 4. THE INTEGRITY CHECK
        // If our index didn't process all 'numCourses', it means there's a circular lock loop
        if (index != numCourses) {
            return new int[0]; // Return an empty array [] because graduation is blocked
        }
        
        return order; // Return the valid schedule order
    }
}
