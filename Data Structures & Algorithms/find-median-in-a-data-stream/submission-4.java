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
     if(maxHeap.isEmpty() || maxHeap.peek()>num) {
        maxHeap.offer(num);
     } else {
        minHeap.offer(num);
     }
    if (maxHeap.size()-minHeap.size()>1) {
        minHeap.offer(maxHeap.poll());
    } else if(minHeap.size()-maxHeap.size()>1) {
        maxHeap.offer(minHeap.poll());
    }
    }
    
    public double findMedian() {
        if (minHeap.size()==maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
         else if (minHeap.size()>maxHeap.size()) {
            return minHeap.peek();
         } else {
            return maxHeap.peek();
         }
    }
}
