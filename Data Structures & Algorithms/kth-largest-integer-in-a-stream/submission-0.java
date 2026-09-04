class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) add(num);
    }
    
    public int add(int val) {
        this.pq.offer (val);

        if (this.pq.size() > k) {
            this.pq.poll();
        }

        return this.pq.peek();
    }
}
