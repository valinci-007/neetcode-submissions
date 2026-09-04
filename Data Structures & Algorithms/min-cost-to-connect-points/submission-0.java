class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] vis = new boolean[n];
        int cost = 0;

        List<Integer> nodes = new ArrayList<>();
        minDist[0] = 0;

        while(nodes.size() < n){
            // Find the cheapest node
            int node = -1;
            for(int i=0; i<n; i++){
                if(vis[i]) continue;
                if(node == -1 || minDist[i] < minDist[node]){
                    node = i;
                }
            }

            nodes.add(node);
            vis[node] = true;
            cost += minDist[node];

            for(int next=0; next<n; next++){
                if(vis[next]) continue;

                int distance = Math.abs(points[node][0]-points[next][0]) + 
                                Math.abs(points[node][1] - points[next][1]);
                minDist[next] = Math.min(minDist[next], distance);
            }
        }

        return cost;
    }
}
