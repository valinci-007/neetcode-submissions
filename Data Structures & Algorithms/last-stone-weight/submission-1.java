
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            pq.offer (i);
        }

        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            if (s1 == s2) continue;
            pq.offer (Math.abs (s1 - s2));
        }

        return pq.peek() == null ? 0 : pq.peek();
    }
}
