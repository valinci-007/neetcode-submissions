class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dis = new int[n+1];
        for(int i=0; i<n+1; i++){
            dis[i] = Integer.MAX_VALUE;
        }

        // 0 -> {{}, {}}
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});
        dis[k] = 0;

        while(!pq.isEmpty()){
            int[] item = pq.poll();
            int node = item[1];
            int d = item[0];

            for(int[] nei : adj.get(node)){
                int neiNode = nei[0];
                int edgeWei = nei[1];

                if (d + edgeWei < dis[neiNode]) {
                    dis[neiNode] = d + edgeWei;
                    pq.offer(new int[]{dis[neiNode], neiNode});
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++){
            if(dis[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dis[i]);
        }

        return ans;
    }
}
