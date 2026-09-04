class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : flights){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        Queue<int[]> q = new ArrayDeque<>(); // {stops, cost, airport}
        q.offer(new int[]{0, 0, src});
        minCost[src] = 0; 

        while(!q.isEmpty()){
            int[] item = q.poll();
            int stops = item[0];
            int cost = item[1];
            int airport = item[2];

            if(stops > k) continue;

            for(int[] nei : adj.get(airport)){
                int nextAirport = nei[0];
                int price = nei[1];

                if(cost + price < minCost[nextAirport]){
                    minCost[nextAirport] = cost + price;
                    q.offer(new int[]{stops + 1, minCost[nextAirport], nextAirport});
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
