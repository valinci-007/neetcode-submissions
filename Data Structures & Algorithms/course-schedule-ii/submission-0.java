class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. Create the adj list
        // 2. Find all independent courses
        // 3. complete independent courses and process the dependent courses

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

        List<Integer> order = new ArrayList<>();
        while(!q.isEmpty()){
            int course = q.poll();
            order.add(course);

            for(int nei: adj.get(course)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }

        if (order.size() != numCourses) {
            return new int[]{};
        }

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }
}
