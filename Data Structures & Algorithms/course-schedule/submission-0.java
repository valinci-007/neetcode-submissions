class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [a, b] means b --> a
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int completed = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            completed ++;

            for(int nei: adj.get(course)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }

        return completed == numCourses;
    }
}
