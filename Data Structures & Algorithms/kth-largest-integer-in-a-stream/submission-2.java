class KthLargest {
    PriorityQueue<Integer> pq;
    int maxSize;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        maxSize=k;
        for(int num:nums) {
            pq.offer(num);
            if(pq.size()>k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>maxSize) {
            pq.poll();
        }
        return pq.peek();
    }
}
