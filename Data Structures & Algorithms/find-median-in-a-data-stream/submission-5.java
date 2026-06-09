class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        Comparator<Integer> c = (a, b) -> {
            return b-a;
        };
        maxHeap = new PriorityQueue<>(c);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || (!minHeap.isEmpty() && minHeap.peek()>num)) {
            maxHeap.offer(num);
        } else if(!minHeap.isEmpty() && minHeap.peek()<num) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        if(maxHeap.size()>minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size()>maxHeap.size()+1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        } else if(maxHeap.size()>minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
