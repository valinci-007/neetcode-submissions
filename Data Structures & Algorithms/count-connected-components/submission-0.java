class Solution {
    private void bfs(int start, boolean[] vis, List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int nei: adj.get(node)){
                if(!vis[nei]){
                    q.add(nei);
                    vis[nei] = true;
                }
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                bfs(i, vis, adj);
                cnt++;
            }
        }

        return cnt;
    }
}
