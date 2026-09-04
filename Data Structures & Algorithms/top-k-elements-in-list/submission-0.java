class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int f = entry.getValue();
            int ele = entry.getKey();

            pq.offer(new int[]{f, ele});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll()[1];
            i++;
        }

        return res;
    }
}
