class MedianFinder {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        small.offer (num);

        if (small.peek() != null && large.peek() != null && small.peek() > large.peek()) {
            large.offer (small.poll());
        }

        if (small.size() - large.size() > 1) {
            large.offer (small.poll());
        } else if (large.size() - small.size() > 1) {
            small.offer (large.poll());
        }
    }
    
    public double findMedian() {
        int n = small.size();
        int m = large.size();

        if (n > m) {
            return (double) small.peek();
        } else if (m > n) {
            return (double) large.peek();
        }

        return (double) (small.peek() + large.peek()) / 2.0;
    }
}
