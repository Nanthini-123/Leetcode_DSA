class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]pair : prerequisites){
            int course=pair[0];
            int preq=pair[1];
            adj.get(preq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int coursescompleted=0;
        while(!queue.isEmpty()){
            int currentcourse=queue.poll();
            coursescompleted++;
        
            for(int nextcourse:adj.get(currentcourse)){
                indegree[nextcourse]--;
                if(indegree[nextcourse]==0){
                    queue.offer(nextcourse);
               
                }
             }
        }
        return coursescompleted==numCourses  ;   
        
    }
}